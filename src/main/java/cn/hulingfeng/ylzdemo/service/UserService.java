package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.UserMapper;
import cn.hulingfeng.ylzdemo.model.po.User;
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
}
