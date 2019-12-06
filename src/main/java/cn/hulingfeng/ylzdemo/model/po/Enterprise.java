package cn.hulingfeng.ylzdemo.model.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author hlf
 * @title: Enterprise
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/6 15:04
 */
@Data
public class Enterprise {
    private Integer companyId;
    private String companyName;
    private String address;
    private Date registerDate;
    private String principal;
    private String type;
    private String businessPhone;
    private Double asset;

    private List<Project> projects;
    private List<Staff> staffs;
}
