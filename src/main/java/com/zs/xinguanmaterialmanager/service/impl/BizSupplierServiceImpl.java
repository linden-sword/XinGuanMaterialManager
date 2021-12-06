package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.mapper.BizSupplierMapper;
import com.zs.xinguanmaterialmanager.service.BizSupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizSupplier)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:35
 */
@Service("bizSupplierService")
public class BizSupplierServiceImpl implements BizSupplierService {
    @Resource
    private BizSupplierMapper bizSupplierMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizSupplier queryById(Long id) {
        return this.bizSupplierMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizSupplier 实例对象
     * @return 实例对象
     */
    @Override
    public BizSupplier insert(BizSupplier bizSupplier) {
        this.bizSupplierMapper.insert(bizSupplier);
        return bizSupplier;
    }

    /**
     * 修改数据
     *
     * @param bizSupplier 实例对象
     * @return 实例对象
     */
    @Override
    public BizSupplier update(BizSupplier bizSupplier) {
        this.bizSupplierMapper.update(bizSupplier);
        return this.queryById(bizSupplier.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizSupplierMapper.deleteById(id) > 0;
    }
}
