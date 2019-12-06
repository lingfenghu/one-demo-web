package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.EnterpriseMapper;
import cn.hulingfeng.ylzdemo.model.po.Enterprise;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class EnterpriseController {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @GetMapping("enterprise")
    public ResultUtil listCompany(){
        List<Enterprise> enterpriseList = enterpriseMapper.list();
        ResultUtil resultUtil = new ResultUtil(200,"查询所有企业成功",enterpriseList.get(0).getCompanyName());
        return resultUtil;
    }
}
