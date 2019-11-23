package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.service.UserService;
import cn.hulingfeng.ylzdemo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hlf
 * @title: MainController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:46
 */
@RestController
public class MainController {

    @Autowired
    private UserService userService;
    /**
     * 登录主页访问
     * @return
     */
    @RequestMapping(value = {"/index","/"})
    public String index(){
        return "index";
    }

    @PostMapping(value = {"/login"})
    public ResponseUtil login(@RequestBody User user){
        return userService.login(user);
    }
}
