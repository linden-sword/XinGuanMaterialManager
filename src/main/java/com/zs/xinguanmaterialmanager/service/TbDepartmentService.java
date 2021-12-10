package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbDepartment;

import java.util.List;

/**
 * (TbDepartment)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:36
 */
public interface TbDepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbDepartment edit(long id);

    /**
     * 查询所有
     * @param
     * @return
     */
    List<TbDepartment> findAll();

    /**
     * 模糊查询
     * @param department
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo findDepartmentList(TbDepartment department, int pageNum, int pageSize);

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
    int update(long id,TbDepartment tbDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(long id);

}
