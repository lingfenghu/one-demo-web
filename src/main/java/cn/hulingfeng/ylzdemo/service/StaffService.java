package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.StaffMapper;
import cn.hulingfeng.ylzdemo.model.po.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hlf
 * @title: StaffService
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 13:10
 */
@Service
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;

    public boolean addStaff(Staff staff){
        return staffMapper.add(staff);
    }

    public List<Staff> list(){
        return staffMapper.list();
    }
}
