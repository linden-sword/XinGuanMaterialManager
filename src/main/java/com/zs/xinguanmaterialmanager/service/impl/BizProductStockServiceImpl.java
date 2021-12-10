package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizProductStock;
import com.zs.xinguanmaterialmanager.mapper.BizProductStockMapper;
import com.zs.xinguanmaterialmanager.service.BizProductStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizProductStock)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:33
 */
@Service("bizProductStockService")
public class BizProductStockServiceImpl implements BizProductStockService {
    @Resource
    private BizProductStockMapper bizProductStockMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizProductStock queryById(Long id) {
        return this.bizProductStockMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizProductStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizProductStock insert(BizProductStock bizProductStock) {
        this.bizProductStockMapper.insert(bizProductStock);
        return bizProductStock;
    }

    /**
     * 修改数据
     *
     * @param bizProductStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizProductStock update(BizProductStock bizProductStock) {
        this.bizProductStockMapper.update(bizProductStock);
        return this.queryById(bizProductStock.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizProductStockMapper.deleteById(id) > 0;
    }
}
