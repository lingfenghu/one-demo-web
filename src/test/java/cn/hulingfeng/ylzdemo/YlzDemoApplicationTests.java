package cn.hulingfeng.ylzdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@SpringBootTest
class YlzDemoApplicationTests {

    @Test
    void contextLoads() {
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

}
