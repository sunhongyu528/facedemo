package com.changhongit.facedemo;


import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import com.changhongit.facedemo.utils.BaiDuAIUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class FastTest {

    //https://www.bilibili.com/video/BV1mJ411k7nD?p=8&spm_id_from=pageDriver

    private AipFace aipFace;

    private  BaiDuAIUtils baiDuAIUtils;

    @Test
    public void testRegister() throws Exception{
        //1.创建和百度云的交互

        aipFace=new AipFace("20114724","w9KGBy3LB27898lkyqg9EtTK","TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb");


        //2、参数设置

        HashMap<String,String> options=new HashMap<>();
        options.put("liveness_control","LOW");//活体检查
        options.put("quality_control","NORMAL");//图片质量


        //3。构造图片
        String path="/Users/sunhongyu/IdeaProjects/facedemo/src/main/resources/static/face/face1.jpeg";
        byte[] bytes= Files.readAllBytes(Paths.get(path));
        String encode = Base64Util.encode(bytes);
        //下面的参数
        //1、图片的url或Base64字符串
        //2、图片格式URL\BASE64
        //3、组ID
        //4、用户ID
        //5、HaspMap的options

        JSONObject register1 = aipFace.addUser(encode, "BASE64", "poc1", "1000", options);
        System.out.println(register1.toString());

        //4、调用api完成注册
    }


    //返回数组取第一即可，   score值80分以上
    @Test
    public void testFaceSearch() throws Exception{
        aipFace=new AipFace("20114724","w9KGBy3LB27898lkyqg9EtTK","TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb");

        //构造图片
        String path="/Users/sunhongyu/IdeaProjects/facedemo/src/main/resources/static/face/face3.jpeg";
        byte[] bytes= Files.readAllBytes(Paths.get(path));
        String encode = Base64Util.encode(bytes);

        //人脸搜索
        JSONObject search = aipFace.search(encode, "BASE64", "poc1", null);
        System.out.println(search);

    }

    @Test
    public void facedel(){
        aipFace=new AipFace("20114724","w9KGBy3LB27898lkyqg9EtTK","TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb");
        HashMap<String, String> options = new HashMap<String, String>();

        String userId = "80210";
        String groupId = "poc1";
        String faceToken = "3d8e93de97b3ed4dd9c40bb9dda2faf9";

        JSONObject jsonObject = aipFace.faceDelete(userId, groupId, faceToken, options);
        System.out.println(jsonObject.toString());
    }


    @Test
    public void userGet(){
        aipFace=new AipFace("20114724","w9KGBy3LB27898lkyqg9EtTK","TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb");
        HashMap<String, String> options = new HashMap<String, String>();
        String userId = "80210";
        String groupId = "poc1";
        // 用户信息查询
        JSONObject res = aipFace.getUser(userId, groupId, options);
        System.out.println(res.toString());
    }


    @Test
    public void usergetList() throws JSONException {
//        aipFace=new AipFace("20114724","w9KGBy3LB27898lkyqg9EtTK","TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb");
//
//        // 传入可选参数调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
//
//        String userId = "80210";
//        String groupId = "poc1";
//
//        // 获取用户人脸列表
//        JSONObject res = aipFace.faceGetlist(userId, groupId, options);
//        System.out.println(res.toString());
//        String result = res.getString("result");
//        System.out.println(result);
//        String[] split = result.split(":");
//
//        int length = split.length;
//        System.out.println(length);
//        String str=split[5];
//        String faceToken =str.substring(1,str.length()-4);
//        System.out.println(faceToken);

    }

}
