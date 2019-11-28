package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.vo.StatisticSex;
import com.github.pagehelper.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hlf
 * @title: StaffMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/11/24 13:11
 */
@Mapper
public interface StaffMapper {

    /**
     *
     * @param staff
     * @return
     */
    Boolean add(Staff staff);

    /**
     * 查询所有人员
     * @return
     */
    List<Staff> list();

    /**
     *
     * @param staffName
     * @param project
     * @param cardId
     * @return
     */
    List<Staff> queryByParamenters(@Param("project") String project,@Param("cardId") String cardId,@Param("staffName") String staffName);

    /**
     *
     * @param staff
     * @return
     */
    Boolean update(@Param("staff") Staff staff);

    /**
     *
     * @param staffId
     * @return
     */
    Boolean delete(@Param("staffId") Integer staffId);

    /**
     *
     * @return
     */
    List<StatisticSex> statsBySexWithParams(@Param("jobType")String jobType, @Param("ageBegin")Integer ageBegin, @Param("ageEnd")Integer ageEnd, @Param("grade")String grade );
}
