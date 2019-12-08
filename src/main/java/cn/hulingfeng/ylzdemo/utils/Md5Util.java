package cn.hulingfeng.ylzdemo.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author hlf
 * @title: Md5Util
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/2 17:46
 */
public class Md5Util {

    /**
     * 确定加密算法
     * @param string
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String EncoderByMd5(String string) {
        //确定计算方法
        String newStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            BASE64Encoder base64 = new BASE64Encoder();
            //加密后的字符串
            newStr = base64.encode(md5.digest(string.getBytes("utf-8")));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return newStr;
    }
}
