package cn.hulingfeng.ylzdemo.utils;

import lombok.Data;

/**
 * @author hlf
 * @title: ResponseUtil
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/22 23:40
 */
@Data
public class ResponseUtil {
    private Integer code;
    private String msg;
    private Object object;
}
