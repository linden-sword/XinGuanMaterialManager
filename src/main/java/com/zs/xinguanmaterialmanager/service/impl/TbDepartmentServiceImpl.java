package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbDepartment;
import com.zs.xinguanmaterialmanager.mapper.TbDepartmentMapper;
import com.zs.xinguanmaterialmanager.service.TbDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TbDepartment)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:36
 */
@Service("tbDepartmentService")
public class TbDepartmentServiceImpl implements TbDepartmentService {
    @Resource
    private TbDepartmentMapper tbDepartmentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbDepartment queryById(Long id) {
        return this.tbDepartmentMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public TbDepartment insert(TbDepartment tbDepartment) {
        this.tbDepartmentMapper.insert(tbDepartment);
        return tbDepartment;
    }

    /**
     * 修改数据
     *
     * @param tbDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public TbDepartment update(TbDepartment tbDepartment) {
        this.tbDepartmentMapper.update(tbDepartment);
        return this.queryById(tbDepartment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbDepartmentMapper.deleteById(id) > 0;
    }
}
