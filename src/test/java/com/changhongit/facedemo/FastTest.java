package com.changhongit.facedemo;


import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class FastTest {

    //https://www.bilibili.com/video/BV1mJ411k7nD?p=8&spm_id_from=pageDriver

    private AipFace aipFace;



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
}
