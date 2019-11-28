package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hlf
 * @title: JobMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 21:20
 */
//@Mapper
public interface JobMapper {

    /**
     * 查询所有工种
     * @return
     */
    List<Job> list();

    /**
     * 添加工种
     * @return
     */
    Boolean add();

    /**
     * 更新工种
     * @return
     */
    Boolean update(Job job);

    /**
     * 删除工种
     * @return
     */
    Boolean delete(@Param("jobId")Integer jobId);
}
