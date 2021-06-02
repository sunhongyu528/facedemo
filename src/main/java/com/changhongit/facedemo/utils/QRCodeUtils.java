package com.changhongit.facedemo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@Component
public class QRCodeUtils {


    public String crateQRCode(String content) throws Exception{
        System.out.println(content);
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        try{
            QRCodeWriter qrCodeWriter=new QRCodeWriter();
            BitMatrix bitMatrix=qrCodeWriter.encode(content, BarcodeFormat.QR_CODE,200,200);
            BufferedImage bufferedImage= MatrixToImageWriter.toBufferedImage(bitMatrix);
            ImageIO.write(bufferedImage,"png",outputStream);
            return new String("data:image/png;base64"+ Base64.encode(outputStream.toByteArray()));
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            outputStream.close();
        }

        return null;
    }
}
