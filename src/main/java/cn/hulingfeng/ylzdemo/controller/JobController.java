package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.JobMapper;
import cn.hulingfeng.ylzdemo.model.po.Job;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.UserLoginToken;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工种目录控制类
 * @author hlf
 * @title: JobController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/27 17:43
 */
@Slf4j
@RestController
@Api(tags = "工种相关接口")
public class JobController {

    @Autowired
    private JobMapper jobMapper;

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("job")
    @UserLoginToken
    public ResultUtil queryAll(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Job> jobList = jobMapper.list();
        PageInfo<Job> jobs = new PageInfo<>(jobList);
        ResultUtil resultUtil = new ResultUtil(200,"查询工种信息成功",jobs);
        return resultUtil;
    }

    /**
     *
     * @param job
     * @return
     */
    @PutMapping("job")
    @UserLoginToken
    public ResultUtil update(@RequestBody Job job){
        Boolean res = jobMapper.update(job);
        ResultUtil resultUtil= res ? new ResultUtil(200,"修改工种信息成功",res) : new ResultUtil(400,"修改工种信息失败",res);
        return resultUtil;
    }

    /**
     *
     * @param jobId
     * @return
     */
    @DeleteMapping("job")
    @UserLoginToken
    public ResultUtil delete(@RequestParam(name = "jobId") Integer jobId){
        Boolean res = jobMapper.delete(jobId);
        ResultUtil resultUtil= res ? new ResultUtil(200,"删除工种信息成功",res) : new ResultUtil(400,"删除工种信息失败",res);
        return resultUtil;
    }
}
