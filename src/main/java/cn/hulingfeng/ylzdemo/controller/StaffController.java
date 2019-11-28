package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.mapper.StaffMapper;
import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.vo.StatisticSex;
import cn.hulingfeng.ylzdemo.service.StaffService;
import cn.hulingfeng.ylzdemo.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hlf
 * @title: StaffController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:49
 */
@RestController
public class StaffController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffMapper staffMapper;

    /**
     * @return
     */
//    @RequestMapping("/base_info")
//    public String addStaff() {
//        return "staff_info";
//    }

    /**
     * 分页查询所有人员
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("staff")
    public ResultUtil listStaff(
            @RequestParam(name = "project",defaultValue = "",required = false) String project,
            @RequestParam(name = "cardId",defaultValue = "",required = false) String cardId,
            @RequestParam(name = "staffName",defaultValue = "",required = false) String staffName,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize) {
//        List<Staff> staffList = staffService.list();project,cardId,
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> staffList = staffMapper.queryByParamenters(project,cardId,staffName);
        PageInfo<Staff> staffs = new PageInfo<>(staffList);
        ResultUtil resultUtil = new ResultUtil(200,"查询人员信息成功",staffs);
//        return ResultUtil.create(200,"查询人员信息成功");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("staff_list");
//        modelAndView.addObject("data",staffs);
//        return modelAndView;
        return resultUtil;
    }

    /**
     * @param httpServletRequest
     * @return java.lang.String
     * @Description(添加人员)
     * @date 2019/11/24
     */
    @PostMapping("staff")
    public ResultUtil addStaff(@RequestBody Staff staff, HttpServletRequest httpServletRequest) {
        String authToken = httpServletRequest.getHeader(tokenHeader);
        System.out.println(authToken);
//        Staff staff = new Staff();
//        staff.setStaffName(httpServletRequest.getParameter("staffName"));
//        staff.setSex(Boolean.parseBoolean(httpServletRequest.getParameter("sex")));
//        staff.setIdentityId(httpServletRequest.getParameter("identityNum"));
//        staff.setJobGrade(httpServletRequest.getParameter("staffJobGrade"));
//        staff.setTel(httpServletRequest.getParameter("staffTel"));
//        staff.setCardId(httpServletRequest.getParameter("staffCardId"));
//        staff.setSalaryCardId(httpServletRequest.getParameter("staffSalaryCardId"));
        staffService.addStaff(staff);
//        try {
//            httpServletResponse.sendRedirect("/staff/list");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return ResultUtil.create(200,"新增人员信息成功");
    }

    /**
     *
     * @param staff
     * @return
     */
    @PutMapping("staff")
    public ResultUtil updateStaff(@RequestBody Staff staff) {
        Boolean res = staffMapper.update(staff);
        ResultUtil resultUtil;
        if(res){
            resultUtil = new ResultUtil(200,"修改人员信息成功",res);
        }else{
            resultUtil = new ResultUtil(500,"修改人员信息失败",res);
        }
        return resultUtil;
    }

    /**
     *
     * @param staffId
     * @return
     */
    @DeleteMapping("staff")
    public ResultUtil deleteStaff(@RequestParam(name = "staffId")Integer staffId) {
        Boolean res = staffMapper.delete(staffId);
        ResultUtil resultUtil =  res ? new ResultUtil(200,"删除人员信息成功",res) : new ResultUtil(500,"删除人员信息失败",res);
        return resultUtil;
    }

    /**
     *
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @GetMapping("statistics/age")
    public ResultUtil statisticByAgeWithParams(
            @RequestParam(name = "jobType") Integer param1,
            @RequestParam(name = "ageInterval") Integer param2,
            @RequestParam(name = "grade") Integer param3){
        List<StatisticSex> statsResult = staffService.statisticByAgeWithParams(param1,param2,param3);
        ResultUtil resultUtil = new ResultUtil(200,"统计查询成功",statsResult);
        return resultUtil;
    }
}
