package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.service.UserService;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.UserLoginToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户信息控制类
 * @author hlf
 * @title: UserController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 10:41
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 权限访问测试
     * @return
     */
    @UserLoginToken
    @RequestMapping("user/index")
    public String userIndex(){
        return "user_index";
    }

    /**
     * 获取图形验证码
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
   @GetMapping("user/getAuthCode")
    public void getAuthCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        try{
            httpServletResponse.setContentType("image/jpeg");
            httpServletResponse.setHeader("Cache-Control", "no-cache");
            httpServletResponse.setHeader("Pragma", "No-cache");
            httpServletResponse.setDateHeader("Expire", 0);
            userService.getAuthCode(httpServletRequest,httpServletResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 用户登录
     * @param requestMap
     * @return
     */
    @PostMapping(value = {"user/login"})
    public ResultUtil login(@RequestBody Map<String, Object> requestMap){
        User user = new User((String)requestMap.get("username"),(String) requestMap.get("password"));
        ResultUtil resultUtil = userService.login(user);
        return resultUtil;
    }

    /**
     * 验证码验证
     * @param requestMap
     * @param session
     * @return
     */
    @PostMapping("user/checkCode")
    public Boolean checkImgCode(@RequestBody Map<String, Object> requestMap, HttpSession session){
        String randomCode = (String) session.getAttribute("keyCode");
        log.info("randomCode:"+randomCode+"|inputCode:"+requestMap.get("imgCode"));
        if (randomCode == null) {
            return false;
        }
        if (randomCode.equals(requestMap.get("imgCode"))) {
            return true;
        } else {
            return false;
        }
    }
}
