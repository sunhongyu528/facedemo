package com.changhongit.facedemo.controller;

import com.baidu.aip.face.AipFace;
import com.changhongit.facedemo.utils.BaiDuAIUtils;
import com.google.zxing.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/face")
public class FaceLoginContorller {
    @Autowired
    private BaiDuAIUtils baiDuAIUtils;

    //刷脸登录二维码  返回QRcode对象（code，image）
    @RequestMapping(value = "/qrcode",method = RequestMethod.GET)
    public Result qrcode() throws Exception{
        return null;
    }

    //验证二维码，登录页面轮训，查看code唯一值，判断用户
    //查询二维码状态，，返回FaceloginResult，state：-1，0，1（"userid")
    @RequestMapping(value = "/qrcode/{code}",method = RequestMethod.GET)
    public Result qrcodeCheck(@PathVariable(name="code") String code) throws Exception{
        return null;
    }


    //人脸登录
    @RequestMapping("/loginByFace")
    public String loginByFace(@RequestParam String img) throws Exception{
        System.out.println("人脸识别开始");
        System.out.println(img);
        String s = baiDuAIUtils.faceSearch(img);
        System.out.println(s);
        String s1="分机"+s+"，已经登录";
        System.out.println(s1);
        return s;

    }

    //检查图片是否是人脸
    @RequestMapping(value = "/checkFace",method = RequestMethod.POST)
    public Result checkFace(@RequestParam(name ="file") MultipartFile attachment) throws Exception{
        return null;
    }





    @RequestMapping("/register1")
    public String register(@RequestParam String phone,@RequestParam String img) throws Exception{
        System.out.println("注册开始！！！");
        System.out.println(phone);

        System.out.println(new String("data:image/png;base64,"+img));

        AipFace aipFace=new AipFace("20114724","w9KGBy3LB27898lkyqg9EtTK","TIGU9668Le6MA7wbBzHg8ESQGqpSjUGb");


        //2、参数设置

        HashMap<String,String> options=new HashMap<>();
        options.put("liveness_control","LOW");//活体检查
        options.put("quality_control","NORMAL");//图片质量
        JSONObject register1 = aipFace.addUser(img, "BASE64", "poc1", phone, options);
        System.out.println(register1.toString());
        return register1.toString();
    }
}
