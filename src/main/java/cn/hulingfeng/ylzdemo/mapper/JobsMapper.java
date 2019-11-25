package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Jobs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hlf
 * @title: JobsMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 21:20
 */
//@Mapper
public interface JobsMapper {

    /**
     * 查询所有工种
     * @return
     */
    List<Jobs> list();

    /**
     * 添加工种
     * @return
     */
    Boolean add();

    /**
     * 更新工种
     * @return
     */
    Boolean update();

    /**
     * 删除工种
     * @return
     */
    Boolean delete();
}
