package cn.hulingfeng.ylzdemo.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 图形验证码工具类
 * @author hlf
 * @title: AuthCodeUtil
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/22 10:31
 */
public class AuthCodeUtil {

    /**
     * 图形验证码生成
     */
    public static Map generateAuthCode() {
        Map<String,Object> map = new HashMap();
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
        String randomCode = hash1.substring(0,4);
        map.put("key",randomCode);
        g.setColor(new Color(0,100,0));
        g.setFont(new Font("Candara",Font.BOLD,24));
        g.drawString(randomCode,8,24);
        g.dispose();
        map.put("img",image);
        return map;
    }
}
