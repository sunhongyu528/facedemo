package com.changhongit.facedemo.service;

import com.changhongit.facedemo.pojo.FaceLoginResult;
import com.changhongit.facedemo.pojo.QRCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FaceLoginService {
    @Value("${qr.url}")
    private String url;


    //创建二维码
    public QRCode getQRCode() throws Exception{
        return null;
    }
    //根据唯一值，查询用户是否登录
    public FaceLoginResult checkQRCode(String code){
        return null;
    }

    //使用扫描二维码后，获取图片登录
    public String loginByFace(String code, MultipartFile attachment) throws Exception{
        return null;
    }

    //构造缓存key
    private String getCacheKey(String code){
        return "qrcode"+code;
    }
}
