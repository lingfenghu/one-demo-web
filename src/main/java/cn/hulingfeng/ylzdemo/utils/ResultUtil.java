package cn.hulingfeng.ylzdemo.utils;

import lombok.Data;

/**
 * @author hlf
 * @title: ResultUtil
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/22 23:40
 */
@Data
public class ResultUtil {
    private Integer code;
    private String msg;
    private Object object;
}
