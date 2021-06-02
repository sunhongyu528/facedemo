package com.changhongit.facedemo.utils;


import com.baidu.aip.face.AipFace;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class BaiDuAIUtils {

    private String APP_ID="20114724";
    private String API_KEY="w9KGBy3LB27898lkyqg9EtTK";
    private String SECRET_KEY="TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb";
    private String IMGE_TYPE="BASE64";
    private String groupId="poc1";

    private AipFace client;
    private HashMap<String,String> options=new HashMap<>();

    public BaiDuAIUtils(){
        options.put("liveness_control","LOW");//活体检查
        options.put("quality_control","NORMAL");//图片质量
    }

    @PostConstruct
    public void init(){
        client=new AipFace(APP_ID,API_KEY,SECRET_KEY);
    }


    //人脸注册：上传用户人脸到人脸库

    public  Boolean faceRegister(String userId,String image){
        JSONObject res=client.addUser(image,IMGE_TYPE,groupId,userId,options);
        Integer errorCode=res.getInt("error_code");
        return errorCode==0?true:false;
    }

    //人脸更新：上传用户人脸到人脸库

    public  Boolean faceUpdate(String userId,String image){
        JSONObject res=client.updateUser(image,IMGE_TYPE,groupId,userId,options);
        Integer errorCode=res.getInt("error_code");
        return errorCode==0?true:false;
    }
    //人脸检查：判断图片是否是人脸、及1个人

    public  Boolean faceCheck(String image){
        JSONObject res=client.detect(image,IMGE_TYPE,options);
        if (res.has("error_code")&&res.getInt("error_code")==0){
            JSONObject resultObject = res.getJSONObject("result");
            Integer faceNum=resultObject.getInt("face_num");
            return faceNum==1?true:false;
        }else {
            return false;
        }
    }
    //人脸查找

    public String faceSearch(String image){
        JSONObject res = client.search(image, IMGE_TYPE, groupId, options);

        if(res.has("error_code")&&res.getInt("error_code")==0){
            JSONObject result = res.getJSONObject("result");
            JSONArray user_list = result.getJSONArray("user_list");
            if(user_list.length()>0){
                JSONObject user=user_list.getJSONObject(0);
                double score = user.getDouble("score");
                if (score >80){
                    return user.getString("user_id");
                }
            }

        }
        return null;
    }

    //人脸删除

    public void faceDel(String userid){


        System.out.println("开始删除");
        String groupId = "poc1";
        System.out.println(userid);



        JSONObject jsonObject = client.faceGetlist(userid, groupId, null);


        System.out.println(jsonObject.toString());
        JSONObject result = jsonObject.getJSONObject("result");
        System.out.println(result);
        String face_list = result.toString();
        System.out.println(face_list);
        String[] split = face_list.split(":");

        int length = split.length;
        System.out.println(length);
        String str=split[5];
        String faceToken =str.substring(1,str.length()-4);
        System.out.println(faceToken);

        client.faceDelete(userid, groupId, faceToken, null);

    }

}
