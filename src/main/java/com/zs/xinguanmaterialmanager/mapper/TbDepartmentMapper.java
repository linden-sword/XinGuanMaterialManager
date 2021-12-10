package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (TbDepartment)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:36
 */
@Mapper
public interface TbDepartmentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbDepartment edit(long id);

    /**
     * 查询所有
     *
     * @param tbDepartment
     * @return
     */
    List<TbDepartment> findDepartmentList(TbDepartment tbDepartment);

    List<TbDepartment> findAll();

    /**
     * 新增数据
     *
     * @param tbDepartment 实例对象
     * @return 影响行数
     */
    int add(TbDepartment tbDepartment);


    /**
     * 修改数据
     *
     * @param tbDepartment 实例对象
     * @return 影响行数
     */
    int update(TbDepartment tbDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(long id);

}