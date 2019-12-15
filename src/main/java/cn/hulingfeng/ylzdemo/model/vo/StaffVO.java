package cn.hulingfeng.ylzdemo.model.vo;

import lombok.Data;
import java.util.List;

/**
 * @author hlf
 * @title: StaffVO
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/8 16:17
 */
@Data
public class StaffVO {
    private Integer staffId;
    private Integer companyId;
    private String staffName;
    private Integer sex;
    private Integer age;
    private String identityId;
    private String tel;
    private String cardId;
    private String salaryCardId;
    private String jobType;
    private String grade;
    private String avatarUrl;

    private List<Integer> projectList;
}
