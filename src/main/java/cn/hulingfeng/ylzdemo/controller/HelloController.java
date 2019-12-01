package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.UserMapper;
import cn.hulingfeng.ylzdemo.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * 测试控制类
 * @author hlf
 * @title: HelloController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:34
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    //require避免烦人的波浪错误提示,设置警告为warning
    private UserMapper userMapper;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello ylz-demo";
    }

    /**
     * 测试连接
     * @return
     */
    @GetMapping("/listUser")
    public List<User> listUser(){
        return userMapper.list();
    }
}
