package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.EnterpriseMapper;
import cn.hulingfeng.ylzdemo.mapper.ProjectMapper;
import cn.hulingfeng.ylzdemo.model.po.Enterprise;
import cn.hulingfeng.ylzdemo.model.po.Project;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.UserLoginToken;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hlf
 * @title: EnterpriseController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/6 16:02
 */
@RestController
@Api(tags = "企业相关接口")
public class EnterpriseController {

    @Autowired
    private EnterpriseMapper enterpriseMapper;
    @Autowired
    private ProjectMapper projectMapper;
    /**
     * 查询所有企业
     * @return
     */
    @UserLoginToken
    @GetMapping("enterprise")
    public ResultUtil listCompany(){
        List<Enterprise> enterpriseList = enterpriseMapper.list();
        ResultUtil resultUtil = new ResultUtil(200,"查询所有企业成功",enterpriseList);
        return resultUtil;
    }

    /**
     * 查询该企业所有工程
     * @param companyId
     * @return
     */
    @UserLoginToken
    @GetMapping("enterprise/projects")
    public ResultUtil getCompanyProjects(@RequestParam(name = "companyId", required = false,defaultValue = "0")Integer companyId){
        List<Project> projectList = projectMapper.queryByCompany(companyId);
        ResultUtil resultUtil = new ResultUtil(200,"查询该企业所有工程成功",projectList);
        return resultUtil;
    }
}
