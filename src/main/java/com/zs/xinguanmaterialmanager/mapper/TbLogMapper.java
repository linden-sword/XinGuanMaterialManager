package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作日志表(TbLog)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:39
 */
@Mapper
public interface TbLogMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<TbLog> queryAll(TbLog tbLog);


    /**
     * 新增数据
     *
     * @param tbLog 实例对象
     * @return 影响行数
     */
    int insert(TbLog tbLog);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(long id);

}