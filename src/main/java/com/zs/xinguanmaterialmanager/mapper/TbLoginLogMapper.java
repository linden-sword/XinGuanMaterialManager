package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 登录日志表(TbLoginLog)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:40
 */
@Mapper
public interface TbLoginLogMapper {


    /**
     * 查询所有
     * @return
     */
    List<TbLoginLog> queryAll(TbLoginLog loginLog);



    /**
     * 新增数据
     *
     * @param tbLoginLog 实例对象
     * @return 影响行数
     */
    int insert(TbLoginLog tbLoginLog);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(long id);

}

