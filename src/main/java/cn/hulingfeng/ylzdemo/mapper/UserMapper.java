package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hlf
 * @title: UserMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 15:16
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> list();
}
