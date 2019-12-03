package cn.hulingfeng.ylzdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@SpringBootTest
class YlzDemoApplicationTests {

    @Test
    void getImgCode() {
        int width = 80;
        int height = 32;
        //create image
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //set background Color
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0,0,width,height);
        //draw the border
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
        //generate a random instance to generate the codes
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        //make some confusion
        for(int i=0;i<50;i++){
            int x = rdm.nextInt(width);
            int y = rdm.nextInt(height);
            g.drawOval(x,y,0,0);
        }
        //generate a random code
        String codeStr = hash1.substring(0,4);
        System.out.println(codeStr);
        g.setColor(new Color(0,100,0));
        g.setFont(new Font("Candara",Font.BOLD,24));
        g.drawString(codeStr,8,24);
        g.dispose();
        try{
            ImageIO.write(image,"jpeg",new File("auth-code.jpeg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    void encryptPassword() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String string = "123456";
//        String string = "admin";
        MessageDigest md5 = MessageDigest.getInstance("md5");
        BASE64Encoder base64 = new BASE64Encoder();
        //加密后的字符串
        String newStr = base64.encode(md5.digest(string.getBytes("utf-8")));
        System.out.println(newStr);
    }

}
