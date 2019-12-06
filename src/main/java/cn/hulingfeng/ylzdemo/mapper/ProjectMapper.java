package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hlf
 * @title: ProjectMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/6 15:31
 */
public interface ProjectMapper {

    /**
     * 查询所有项目
     * @return
     */
    List<Project> list();

    /**
     *
     * @param companyId
     * @return
     */
//    List<Project> listByCompany(@Param("companyId")Integer companyId);
}
