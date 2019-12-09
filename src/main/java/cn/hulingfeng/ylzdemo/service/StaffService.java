package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.JoinMapper;
import cn.hulingfeng.ylzdemo.mapper.StaffMapper;
import cn.hulingfeng.ylzdemo.model.po.Join;
import cn.hulingfeng.ylzdemo.model.po.Project;
import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.vo.StaffVO;
import cn.hulingfeng.ylzdemo.model.vo.StatisticAge;
import cn.hulingfeng.ylzdemo.model.vo.StatisticSex;
import cn.hulingfeng.ylzdemo.utils.CardIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private JoinMapper joinMapper;

    /**
     * 查询所用人员
     * @return
     */
    public List<Staff> list(){
        return staffMapper.list();
    }

    /**
     * 添加人员信息
     * @param staffVO
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Integer add(StaffVO staffVO) {
        //生成从业卡号
        String currentCardId = staffMapper.getMaxCardId();
        String newCardId = CardIdUtil.getLatestCardId(currentCardId);
        //装填人员信息
        Staff staff = new Staff();
        staff.setCompanyId(staffVO.getCompanyId());
        staff.setCardId(newCardId);
        staff.setStaffName(staffVO.getStaffName());
        staff.setSex(staffVO.getSex());
        staff.setSalaryCardId(staffVO.getSalaryCardId());
        staff.setTel(staffVO.getTel());
        staff.setJobType(staffVO.getJobType());
        staff.setGrade(staffVO.getGrade());
        //检验身份证号是否已存在
        String identityId = staffVO.getIdentityId();
        Integer thisIdentityId = staffMapper.checkIdentityIdExist(identityId);
        if(thisIdentityId > 0){
            return -1;
        }
        staff.setIdentityId(identityId);
        //计算年龄
        if(identityId.length() == 18) {
            Integer birthdateYear = Integer.valueOf(identityId.substring(6, 10));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Integer nowYear = Integer.valueOf(sdf.format(new Date()));
            staff.setAge(nowYear - birthdateYear);
        }
        //人员项目数据插入
        if(staffMapper.add(staff)){
            Join join = new Join();
            join.setStaffId(staff.getStaffId());
            for(Integer projectId : staffVO.getProjectList()){
                join.setProjectId(projectId);
                joinMapper.add(join);
            }
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 更新人员信息及关联
     * @param staffVO
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Boolean update(StaffVO staffVO){
        Staff oldStaff = staffMapper.queryByStaffId(staffVO.getStaffId());
        if(oldStaff==null){
            return false;
        }
        //装填人员信息
        Staff staff = new Staff();
        staff.setStaffId(staffVO.getStaffId());
        staff.setStaffName(staffVO.getStaffName());
        staff.setSex(staffVO.getSex());
        staff.setCompanyId(staffVO.getCompanyId());
        staff.setCardId(staffVO.getCardId());
        staff.setSex(staffVO.getSex());
        staff.setSalaryCardId(staffVO.getSalaryCardId());
        staff.setTel(staffVO.getTel());
        staff.setJobType(staffVO.getJobType());
        staff.setGrade(staffVO.getGrade());
        if(staffMapper.update(staff)){
            //更新人员项目关联为先删除再新增
            List<Project> oldProjects = oldStaff.getProjects();
            if(oldProjects.size()>0){
                joinMapper.delete(staffVO.getStaffId());
            }
            Join join = new Join();
            join.setStaffId(staffVO.getStaffId());
            for(Integer projectId : staffVO.getProjectList()){
                join.setProjectId(projectId);
                joinMapper.add(join);
            }
            return true;
        }else {
            return false;
        }

    }

    /**
     * 删除人员信息及关联
     * @param staffId
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Boolean delete(Integer staffId){
        if(joinMapper.delete(staffId)){
            return staffMapper.delete(staffId);
        }else{
            return false;
        }
    }

    /**
     * 性别统计
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    public List<StatisticSex> statisticByGenderWithParams(Integer param1,Integer param2,Integer param3){
        String jobType = "",grade = "";
        switch (param1){
            case 0: jobType="";break;
            case 1: jobType="普通";break;
            case 2: jobType="特殊";break;
            default:
        }
        Integer ageBegin = 0;
        Integer ageEnd = 0;
        switch (param2){
            case 0: ageBegin=0;ageEnd=0;break;
            case 1: ageBegin=18;ageEnd=30;break;
            case 2: ageBegin=30;ageEnd=45;break;
            case 3: ageBegin=45;ageEnd=60;break;
            default:
        }
        switch (param3){
            case 0: grade="";break;
            case 1: grade="A";break;
            case 2: grade="B";break;
            case 3: grade="C";break;
            default:
        }
        List<StatisticSex> statsResult = staffMapper.statsBySexWithParams(jobType,ageBegin,ageEnd,grade);
        return statsResult;
    }

    /**
     * 年龄段统计
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    public List<StatisticAge> statisticByAgeWithParams(Integer param1, Integer param2, Integer param3){
        String jobType = "",grade = "";
        switch (param1){
            case 0: jobType="";break;
            case 1: jobType="普通";break;
            case 2: jobType="特殊";break;
            default:
        }
        Integer sex = param2;
        switch (param3){
            case 0: grade="";break;
            case 1: grade="A";break;
            case 2: grade="B";break;
            case 3: grade="C";break;
            default:
        }
        List<StatisticAge> statsResult = staffMapper.statsByAgeIntervalWithParams(jobType,sex,grade);
        return statsResult;
    }

}
