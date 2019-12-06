package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Staff;
import cn.hulingfeng.ylzdemo.model.vo.StatisticAge;
import cn.hulingfeng.ylzdemo.model.vo.StatisticSex;
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
     * 添加人员
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
     * 条件查询人员
     * @param staffName
     * @param project
     * @param cardId
     * @return
     */
    List<Staff> queryByParameters(@Param("project") String project,@Param("cardId") String cardId,@Param("staffName") String staffName);

    /**
     * 更新人员信息
     * @param staff
     * @return
     */
    Boolean update(Staff staff);

    /**
     * 删除人员信息
     * @param staffId
     * @return
     */
    Boolean delete(@Param("staffId") Integer staffId);

    /**
     * 获取项目列表
     * @return
     */
    List<String> getProjects();

    /**
     * 条件性别统计
     * @return
     */
    List<StatisticSex> statsBySexWithParams(@Param("jobType")String jobType, @Param("ageBegin")Integer ageBegin, @Param("ageEnd")Integer ageEnd, @Param("grade")String grade );

    /**
     * 年龄段统计
     * @param jobType
     * @param sex
     * @param grade
     * @return
     */
    List<StatisticAge> statsByAgeIntervalWithParams(@Param("jobType")String jobType, @Param("sex")Integer sex, @Param("grade")String grade);

    /**
     * 检验用户从业卡是否已经存在
     * @param cardId
     * @return
     */
    Integer checkCardIdExist(@Param("cardId")String cardId);

    /**
     * 检验用户身份证号是否存在
     * @param identityId
     * @return
     */
    Integer checkIdentityIdExist(@Param("identityId")String identityId);

    /**
     * 查询库表中最大的从业卡号cardID
     * @return
     */
    String getMaxCardId();
}
