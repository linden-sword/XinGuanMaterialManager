package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizInStock;
import com.zs.xinguanmaterialmanager.mapper.BizInStockMapper;
import com.zs.xinguanmaterialmanager.service.BizInStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizInStock)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:25
 */
@Service("bizInStockService")
public class BizInStockServiceImpl implements BizInStockService {
    @Resource
    private BizInStockMapper bizInStockMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizInStock queryById(Object id) {
        return this.bizInStockMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizInStock insert(BizInStock bizInStock) {
        this.bizInStockMapper.insert(bizInStock);
        return bizInStock;
    }

    /**
     * 修改数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizInStock update(BizInStock bizInStock) {
        this.bizInStockMapper.update(bizInStock);
        return this.queryById(bizInStock.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.bizInStockMapper.deleteById(id) > 0;
    }
}
