package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.ProjectMapper;
import cn.hulingfeng.ylzdemo.model.po.Project;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.UserLoginToken;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hlf
 * @title: ProjectController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/6 16:49
 */
@RestController
@Api(tags = "工程相关接口")
public class ProjectController {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 查询所有工程
     * @return
     */
    @UserLoginToken
    @GetMapping("project")
    public ResultUtil listProject(){
        List<Project> projectList =  projectMapper.list();
        ResultUtil resultUtil = new ResultUtil(200,"查询所有工程成功",projectList);
        return resultUtil;
    }
}
