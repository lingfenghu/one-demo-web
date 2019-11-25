package cn.hulingfeng.ylzdemo.model.po;

import lombok.Data;

/**
 * @author hlf
 * @title: Jobs
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 21:20
 */
@Data
public class Jobs {
    private Integer jobId;
    private String skillType;
    private Integer standardSalary;
    private String jobType;
}
