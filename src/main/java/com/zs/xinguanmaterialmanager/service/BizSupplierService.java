package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;

import java.util.Map;

/**
 * (BizSupplier)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:35
 */
public interface BizSupplierService {
//fan
    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizSupplier queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizSupplier 实例对象
     * @return 实例对象
     */
    int insert(BizSupplier bizSupplier);

    /**
     * 修改数据
     *
     * @param bizSupplier 实例对象
     * @return 实例对象
     */
    int update(BizSupplier bizSupplier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Long id);

    /**
     * 所有来源
     * @return
     */
     PageInfo<BizSupplier> findAll(int pageNum,int pageSize);

    /**
     * 根据来源名模糊查询
     * @param
     * @return
     */
    PageInfo<BizSupplier> findSupplierList(Map<String,Object> map,BizSupplier bizSupplier);
//fan
}
