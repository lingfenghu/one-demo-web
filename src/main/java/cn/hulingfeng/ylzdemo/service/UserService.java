package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.UserMapper;
import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResponseUtil login(User user){
        String username = user.getUsername();
        User u = new User();
        ResponseUtil response =  new ResponseUtil();
        List<User> list = userMapper.login(username);
        if(list==null || list.size()<=0){
            response.setCode(401);
            response.setMsg("登录失败");
        }else{
            response.setCode(200);
            response.setMsg("登录成功");
            response.setObject(list.get(0));
        }
        return response;
    }
}
