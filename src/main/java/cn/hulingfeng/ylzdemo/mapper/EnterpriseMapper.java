package cn.hulingfeng.ylzdemo.mapper;

import cn.hulingfeng.ylzdemo.model.po.Enterprise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hlf
 * @title: EnterpriseMapper
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/6 15:31
 */
public interface EnterpriseMapper {

    /**
     * 查询所有企业
     * @return
     */
    List<Enterprise> list();
}
