package cn.hulingfeng.ylzdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 卡号自动生成
 * @author hlf
 * @title: CardIdUtil
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/5 15:36
 */
public class CardIdUtil {
    //初始卡号
    public static String initCardId = "CY201912050000";

    /**
     * 根据当前卡号生成卡号
     * @param currentCardId
     * @return
     */
    public static String getLatestCardId(String currentCardId){
        //生成前10位
        StringBuilder sb = new StringBuilder("CY");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        sb.append(format.format(new Date()));
        //生成后4位
        AtomicInteger num = new AtomicInteger(Integer.valueOf(currentCardId.substring(10)));
        num.getAndIncrement();
        //自动补0
        sb.append(String.format("%04d",num.get()));
        return sb.toString();
    }
}
