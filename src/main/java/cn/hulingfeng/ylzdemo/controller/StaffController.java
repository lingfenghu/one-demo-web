package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.StaffMapper;
import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.vo.*;
import cn.hulingfeng.ylzdemo.service.StaffService;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import cn.hulingfeng.ylzdemo.utils.UserLoginToken;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 人员信息控制类
 * @author hlf
 * @title: StaffController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:49
 */
@Slf4j
@RestController
@Api(tags = "人员相关接口")
public class StaffController {
    //等价@Slf4j
//    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询所有人员 分页
     * @param projectId
     * @param cardId
     * @param staffName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @UserLoginToken
    @GetMapping("staff")
    public ResultUtil listStaff(
            @RequestParam(name = "projectId",defaultValue = "",required = false) String projectId,
            @RequestParam(name = "cardId",defaultValue = "",required = false) String cardId,
            @RequestParam(name = "staffName",defaultValue = "",required = false) String staffName,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> staffList = staffMapper.queryByParameters(projectId,cardId,staffName);
        PageInfo<Staff> staffs = new PageInfo<>(staffList);
        ResultUtil resultUtil = new ResultUtil(200,"查询人员信息成功",staffs);
        return resultUtil;
    }


    /**
     * 添加人员信息
     * @param staffVO
     * @return
     */
    @UserLoginToken
    @PostMapping("staff")
    public ResultUtil addStaff(@RequestBody StaffVO staffVO) {
        Integer res = staffService.add(staffVO);
        switch (res){
            case -1: return new ResultUtil(406,"新增人员身份证号已存在",res);
//            case -1: return new ResultUtil(406,"新增人员从业卡号已存在",res);
            case 0: return new ResultUtil(500,"新增人员信息失败",res);
            case 1: return new ResultUtil(200,"新增人员信息成功",res);
            default: return new ResultUtil(500,"新增人员信息失败",res);
        }
    }

    /**
     * 修改人员信息
     * @param staffVO
     * @return
     */
    @UserLoginToken
    @PutMapping("staff")
    public ResultUtil updateStaff(@RequestBody StaffVO staffVO) {
        Boolean res = staffService.update(staffVO);
        ResultUtil resultUtil= res ? new ResultUtil(200,"修改人员信息成功",res) : new ResultUtil(500,"修改人员信息失败",res);
        return resultUtil;
    }

    /**
     * 删除人员信息
     * @param staffId
     * @return
     */
    @UserLoginToken
    @DeleteMapping("staff")
    public ResultUtil deleteStaff(@RequestParam(name = "staffId")Integer staffId) {
        Boolean res = staffMapper.delete(staffId);
        ResultUtil resultUtil =  res ? new ResultUtil(200,"删除人员信息成功",res) : new ResultUtil(500,"删除人员信息失败",res);
        return resultUtil;
    }

    /**
     * 根据性别统计人员
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @UserLoginToken
    @GetMapping("statistics/gender")
    public ResultUtil statisticByGenderWithParams(
            @RequestParam(name = "jobType") Integer param1,
            @RequestParam(name = "ageInterval") Integer param2,
            @RequestParam(name = "grade") Integer param3){
        List<StatisticSex> statsResult = staffService.statisticByGenderWithParams(param1,param2,param3);
        ResultUtil resultUtil = new ResultUtil(200,"统计查询成功",statsResult);
        return resultUtil;
    }

    /**
     * 根据年龄统计人员
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @UserLoginToken
    @GetMapping("statistics/age")
    public ResultUtil statisticByAgeWithParams(
            @RequestParam(name = "jobType") Integer param1,
            @RequestParam(name = "sex") Integer param2,
            @RequestParam(name = "grade") Integer param3
    ){
        List<StatisticAge> statsResult = staffService.statisticByAgeWithParams(param1,param2,param3);
        ResultUtil resultUtil = new ResultUtil(200,"统计查询成功",statsResult);
        return resultUtil;
    }

    /**
     * 根据工种统计人员
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @GetMapping("statistics/job_type")
    public ResultUtil statisticByJobTypeWithParams(
            @RequestParam(name = "ageInterval") Integer param1,
            @RequestParam(name = "sex") Integer param2,
            @RequestParam(name = "grade") Integer param3
    ){
        List<StatisticJobType> statsResult = staffService.statisticByJobTypeWithParams(param1,param2,param3);
        ResultUtil resultUtil = new ResultUtil(200,"统计查询成功",statsResult);
        return resultUtil;
    }

    /**
     * 根据等级统计人员
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @GetMapping("statistics/grade")
    public ResultUtil statisticByGradeWithParams(
            @RequestParam(name = "sex") Integer param1,
            @RequestParam(name = "jobType") Integer param2,
            @RequestParam(name = "ageInterval") Integer param3
    ){
        List<StatisticGrade> statsResult = staffService.statisticByGradeWithParams(param1,param2,param3);
        ResultUtil resultUtil = new ResultUtil(200,"统计查询成功",statsResult);
        return resultUtil;
    }

    /**
     * 人员头像文件上传
     * @param avatarImag
     */
    @PostMapping("avatar/upload")
    public ResultUtil uploadStaffAvatar(@RequestParam(value = "file") MultipartFile avatarImag){
        String avatarUrl = staffService.uploadStaffAvatar(avatarImag);
        return new ResultUtil(200,"图片上传成功",avatarUrl);
    }
}
