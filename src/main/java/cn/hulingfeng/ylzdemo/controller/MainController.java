package cn.hulingfeng.ylzdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hlf
 * @title: MainController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:46
 */
@Controller
public class MainController {

    /**
     * 登录主页访问
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
