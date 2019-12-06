package cn.hulingfeng.ylzdemo.model.po;

import lombok.Data;

import java.sql.Clob;
import java.util.Date;

/**
 * @author hlf
 * @title: Project
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/6 15:10
 */
@Data
public class Project {
    private Integer projectId;
    private Integer companyId;
    private String projectName;
    private Date setupDate;
    private String projectGrade;
    private String note;
}
