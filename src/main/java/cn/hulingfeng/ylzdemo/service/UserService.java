package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.UserMapper;
import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.utils.AuthCodeUtil;
import cn.hulingfeng.ylzdemo.utils.Md5Util;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author hlf
 * @title: UserService
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 16:09
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> list(){
        return userMapper.list();
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    public ResultUtil login(User user){
        String username = user.getUsername();
        ResultUtil resultUtil = new ResultUtil();
        //验证用户是否存在
        List<User> list = userMapper.queryByUsername(username);
        if(list==null || list.size()<=0){
            resultUtil.setCode(401);
            resultUtil.setMsg("登录失败,用户不存在");
        }else{
            User realUser = list.get(0);
            if(realUser.getPassword().equals(encryptPassword(user.getPassword()))){
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

    /**
     * 前端页面获取验证码
     * @param request
     * @param response
     */
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = AuthCodeUtil.generateAuthCode();
        HttpSession session = request.getSession();
        //保存随机生成的验证号码
        session.removeAttribute("keyCode");
        session.setAttribute("keyCode",map.get("key"));
        try{
            //测试生成文件到指定路径
//            BufferedImage image = (BufferedImage)map.get("img");
//            ImageIO.write(image,"jpeg",new File("src/main/resources/static/img/auth-code.jpeg"));
            ImageIO.write((BufferedImage)map.get("img"),"jpeg",response.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 加密用户密码
     * @return
     */
    public String encryptPassword(String password) {
        return Md5Util.EncoderByMd5(password);
    }

}
