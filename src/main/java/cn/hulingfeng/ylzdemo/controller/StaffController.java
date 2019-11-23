package cn.hulingfeng.ylzdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hlf
 * @title: StaffController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:49
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/list")
    public String listStaff(){
        return "staff list";
    }
}
