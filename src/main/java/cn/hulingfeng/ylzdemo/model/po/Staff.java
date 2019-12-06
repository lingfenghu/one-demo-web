package cn.hulingfeng.ylzdemo.model.po;

import lombok.Data;

/**
 * @author hlf
 * @title: Staff
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 15:00
 */
@Data
public class Staff {
    private Integer staffId;
    private Integer companyId;
    private String staffName;
    private Integer sex;
    private Integer age;
    private String identityId;
    private String jobGrade;
    private String tel;
    private String cardId;
    private String salaryCardId;
    private String project;
    private String enterprise;
    private String jobType;
    private String grade;
}
