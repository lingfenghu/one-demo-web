package cn.hulingfeng.ylzdemo.controller;

import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.po.User;
import cn.hulingfeng.ylzdemo.service.StaffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author hlf
 * @title: StaffController
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/21 14:49
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * @return
     */
    @RequestMapping("/base_info")
    public String addStaff() {
        return "staff_info";
    }

    /**
     * 分页查询所有人员
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ModelAndView listStaff(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> staffList = staffService.list();
        PageInfo<Staff> staffs = new PageInfo<>(staffList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff_list");
        modelAndView.addObject("data",staffs);
        return modelAndView;
    }

    /**
     * @param httpServletRequest
     * @return java.lang.String
     * @Description(添加人员)
     * @date 2019/11/24
     */
    @PostMapping("/to_add")
    public void addStaff(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Staff staff = new Staff();
        staff.setStaffName(httpServletRequest.getParameter("staffName"));
        staff.setSex(Boolean.parseBoolean(httpServletRequest.getParameter("sex")));
        staff.setIdentityId(httpServletRequest.getParameter("identityNum"));
        staff.setJobGrade(httpServletRequest.getParameter("staffJobGrade"));
        staff.setTel(httpServletRequest.getParameter("staffTel"));
        staff.setCardId(httpServletRequest.getParameter("staffCardId"));
        staff.setSalaryCardId(httpServletRequest.getParameter("staffSalaryCardId"));
        staffService.addStaff(staff);
        try {
            httpServletResponse.sendRedirect("/staff/list");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param httpServletRequest
     * @return
     */
    @PutMapping("/")
    public String updateStaff(HttpServletRequest httpServletRequest) {
        return "";
    }
}
