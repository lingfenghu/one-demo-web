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

    public ResultUtil(){

    }

    public ResultUtil(Integer code, String msg, Object object){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    /**
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResultUtil create(Integer code, String msg) {
        ResultUtil result = new ResultUtil();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
