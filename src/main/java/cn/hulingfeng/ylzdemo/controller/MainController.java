package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hlf
 * @title: MainController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:46
 */
//@Controller
@RestController
//@CrossOrigin //解决跨域
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

    /**
     * 访问登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
