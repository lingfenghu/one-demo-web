package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hlf
 * @title: UserMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 17:57
 */
//@Mapper //启动时加上了MapperScan就不需要一一注解
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> list();

    /**
     * 用户登录
     * @param username
     * @return
     */
    List<User> queryByUsername(@Param("username") String username);
}
