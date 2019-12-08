package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Join;

/**
 * @author hlf
 * @title: JoinMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/8 18:49
 */
public interface JoinMapper {

    /**
     * 添加员工项目关联
     * @param join
     * @return
     */
    Boolean add(Join join);
}
