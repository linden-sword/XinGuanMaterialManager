package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbDepartment;

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
    TbDepartment queryById(Long id);

    /**
     * 新增数据
     *
     * @param tbDepartment 实例对象
     * @return 实例对象
     */
    TbDepartment insert(TbDepartment tbDepartment);

    /**
     * 修改数据
     *
     * @param tbDepartment 实例对象
     * @return 实例对象
     */
    TbDepartment update(TbDepartment tbDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
