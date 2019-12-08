package cn.hulingfeng.ylzdemo.utils;

import lombok.Data;

/**
 * 请求返回结果工具类
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

    public ResultUtil() {}

    public ResultUtil(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }
}
