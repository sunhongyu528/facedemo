package com.changhongit.facedemo;

import com.baidu.aip.util.Base64Util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;

public class QRtest1 {
    @Test
    public void test1() throws Exception{
        // 二维码信息
        String url="http://cpaas.changhongit.com";
        //生成二维码

        //1、创建QR对象

        QRCodeWriter qrCodeWriter=new QRCodeWriter();
        //基础配置

        BitMatrix encode = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 200, 200);
        //生成本地图片

        Path path=new File("/Users/sunhongyu/IdeaProjects/facedemo/src/main/resources/static/face/url.png").toPath();


        MatrixToImageWriter.writeToPath(encode,"png",path);
    }

    @Test
    public void test2() throws Exception{
        // 二维码信息
        String url="http://cpaas.changhongit.com";
        //生成二维码

        //1、创建QR对象

        QRCodeWriter qrCodeWriter=new QRCodeWriter();
        //基础配置

        BitMatrix encode = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 200, 200);
        //生成本地图片

        //Path path=new File("/Users/sunhongyu/IdeaProjects/facedemo/src/main/resources/static/face/url.png").toPath();
        //MatrixToImageWriter.writeToPath(encode,"png",path);

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

        BufferedImage image = MatrixToImageWriter.toBufferedImage(encode);

        ImageIO.write(image,"png",byteArrayOutputStream);

        String encode1 = Base64Util.encode(byteArrayOutputStream.toByteArray());

        System.out.println(new String("data:image/png;base64,"+encode1));

    }
}
