package cn.hulingfeng.ylzdemo.model.po;

import lombok.Data;

/**
 * @author hlf
 * @title: Job
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 21:20
 */
@Data
public class Job {
    private Integer jobId;
    private String skillType;
    private Integer standardSalary;
    private String jobType;
}
