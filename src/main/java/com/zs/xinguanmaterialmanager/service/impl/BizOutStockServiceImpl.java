package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizOutStock;
import com.zs.xinguanmaterialmanager.mapper.BizOutStockMapper;
import com.zs.xinguanmaterialmanager.service.BizOutStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizOutStock)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:28
 */
@Service("bizOutStockService")
public class BizOutStockServiceImpl implements BizOutStockService {
    @Resource
    private BizOutStockMapper bizOutStockMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizOutStock queryById(Long id) {
        return this.bizOutStockMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizOutStock insert(BizOutStock bizOutStock) {
        this.bizOutStockMapper.insert(bizOutStock);
        return bizOutStock;
    }

    /**
     * 修改数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizOutStock update(BizOutStock bizOutStock) {
        this.bizOutStockMapper.update(bizOutStock);
        return this.queryById(bizOutStock.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizOutStockMapper.deleteById(id) > 0;
    }
}
