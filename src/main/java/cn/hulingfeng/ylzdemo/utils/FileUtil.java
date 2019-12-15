package cn.hulingfeng.ylzdemo.utils;

import java.util.UUID;

/**
 * 文件处理
 * @author hlf
 * @title: FileUtil
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/12 16:38
 */
public class FileUtil {

    /**
     * 获取文件格式
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf('.'));
    }

    /**
     * 通过UUID随机生成文件名
     * @param fileOriginName
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUID.randomUUID().toString().replaceAll("-","")+getSuffix(fileOriginName);
    }
}
