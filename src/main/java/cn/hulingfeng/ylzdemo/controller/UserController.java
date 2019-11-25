package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.service.UserService;
import cn.hulingfeng.ylzdemo.utils.PassToken;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hlf
 * @title: UserController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 10:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @return
     */
    @UserLoginToken
    @RequestMapping("/index")
    public String userIndex(){
        return "user_index";
    }

    /**
     * 获取验证码
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @GetMapping("/getAuthCode")
    public ResultUtil getAuthCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ResultUtil resultUtil = userService.getAuthCode(httpServletRequest,httpServletResponse);
        return resultUtil;
    }

    /**
     * 用户登录
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws IOException
     */
    @PostMapping(value = {"/login"})
    public ResultUtil login(
            @RequestBody User user,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws IOException {
//        HttpSession httpSession = httpServletRequest.getSession();
//        User user = new User();
//        user.setUsername(httpServletRequest.getParameter("username"));
//        user.setPassword(httpServletRequest.getParameter("password"));

        ResultUtil resultUtil = userService.login(user);
//        if(200 == resultUtil.getCode()){
//            httpSession.setAttribute("user",user);
//            httpServletResponse.sendRedirect("/user/index");
//        }
        return resultUtil;
    }
}
