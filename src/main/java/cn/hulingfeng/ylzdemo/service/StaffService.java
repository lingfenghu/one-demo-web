package cn.hulingfeng.ylzdemo.service;

import cn.hulingfeng.ylzdemo.mapper.StaffMapper;
import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.vo.StatisticAge;
import cn.hulingfeng.ylzdemo.model.vo.StatisticSex;
import cn.hulingfeng.ylzdemo.utils.CardIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 查询所用人员
     * @return
     */
    public List<Staff> list(){
        return staffMapper.list();
    }

    public Integer add(Staff staff) {
        String currentCardId = staffMapper.getMaxCardId();
        String newCardId = CardIdUtil.getLatestCardId(currentCardId);
        staff.setCardId(newCardId);
        String identityId = staff.getIdentityId();
//        Integer thisCard = staffMapper.checkCardIdExist(cardId);
        Integer thisIdentityId = staffMapper.checkIdentityIdExist(identityId);
//        if(thisCard > 0) {
//            return -1;
//        }
        if(thisIdentityId > 0){
            return -1;
        }
        //计算年龄
        if(identityId.length() == 18) {
            Integer birthdateYear = Integer.valueOf(identityId.substring(6, 10));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Integer nowYear = Integer.valueOf(sdf.format(new Date()));
            staff.setAge(nowYear - birthdateYear);
        }
        if(staffMapper.add(staff)){
            return 1;
        }else {
            return 0;
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
