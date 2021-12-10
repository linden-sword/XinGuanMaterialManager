package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbDepartment;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import com.zs.xinguanmaterialmanager.mapper.TbDepartmentMapper;
import com.zs.xinguanmaterialmanager.service.TbDepartmentService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public TbDepartment edit(long id) {
        return tbDepartmentMapper.edit(id);
    }

    /**
     * 查询所有
     *
     * @param
     * @return
     */
    public PageInfo findDepartmentList(TbDepartment tbDepartment, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbDepartment> tbDepartmentList = tbDepartmentMapper.findDepartmentList(tbDepartment);
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(tbDepartmentList);
        return pageInfo;

    }

    public List<TbDepartment> findAll() {
        List<TbDepartment> tbDepartmentList = tbDepartmentMapper.findAll();
        return tbDepartmentList;
    }

    /**
     * 新增数据
     *
     * @param tbDepartment 实例对象
     * @return 影响行数
     */
    public int add(TbDepartment tbDepartment) {
        return tbDepartmentMapper.add(tbDepartment);
    }


    /**
     * 修改数据
     *
     * @param tbDepartment 实例对象
     * @return 影响行数
     */
    public int update(long id, TbDepartment tbDepartment) {
        TbDepartment edit = tbDepartmentMapper.edit(id);
        if (tbDepartment.getName() != null) {
            edit.setName(tbDepartment.getName());
        }
        if (tbDepartment.getPhone() != null) {
            edit.setPhone(tbDepartment.getPhone());
        }
        if (tbDepartment.getAddress() != null) {
            edit.setAddress(tbDepartment.getAddress());
        }
        System.out.println(edit.toString());
        return tbDepartmentMapper.update(edit);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    public int deleteById(long id) {
        return tbDepartmentMapper.deleteById(id);
    }
}
