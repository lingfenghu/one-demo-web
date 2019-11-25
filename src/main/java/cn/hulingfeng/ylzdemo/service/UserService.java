package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.UserMapper;
import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.utils.AuthCodeUtil;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author hlf
 * @title: UserService
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 16:09
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> list(){
        return userMapper.list();
    }

    public ResultUtil login(User user){
        String username = user.getUsername();
        ResultUtil resultUtil = new ResultUtil();
        //验证验证码

        //验证用户是否存在
        List<User> list = userMapper.queryByUsername(username);
        if(list==null || list.size()<=0){
            resultUtil.setCode(401);
            resultUtil.setMsg("登录失败,用户不存在");
        }else{
            User realUser = list.get(0);
            if(realUser.getPassword().equals(user.getPassword())){
                String token = TokenUtil.getToken(list.get(0));
                resultUtil.setCode(200);
                resultUtil.setMsg("登录成功");
                resultUtil.setObject(token);
            }else {
                resultUtil.setCode(401);
                resultUtil.setMsg("登录失败,用户密码不正确");
            }
        }
        return resultUtil;
    }

    public ResultUtil getAuthCode(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        ResultUtil resultUtil =  new ResultUtil();

        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        Map<String,Object> map = AuthCodeUtil.generateAuthCode();
        session.removeAttribute("key");
        session.setAttribute("key",map.get("key"));
        try{
            OutputStream strm = response.getOutputStream();
            ImageIO.write((BufferedImage)map.get("img"),"jpeg",strm);
            strm.close();
            resultUtil.setCode(200);
            resultUtil.setMsg("验证码生成成功");
        }catch (IOException e){
            resultUtil.setCode(500);
            resultUtil.setMsg("验证码生成失败");
            e.printStackTrace();
        }
        return resultUtil;
    }
}
