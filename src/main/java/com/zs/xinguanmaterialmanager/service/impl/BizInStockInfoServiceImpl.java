package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizInStockInfo;
import com.zs.xinguanmaterialmanager.mapper.BizInStockInfoMapper;
import com.zs.xinguanmaterialmanager.service.BizInStockInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizInStockInfo)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:27
 */
@Service("bizInStockInfoService")
public class BizInStockInfoServiceImpl implements BizInStockInfoService {
    @Resource
    private BizInStockInfoMapper bizInStockInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizInStockInfo queryById(Long id) {
        return this.bizInStockInfoMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizInStockInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BizInStockInfo insert(BizInStockInfo bizInStockInfo) {
        this.bizInStockInfoMapper.insert(bizInStockInfo);
        return bizInStockInfo;
    }

    /**
     * 修改数据
     *
     * @param bizInStockInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BizInStockInfo update(BizInStockInfo bizInStockInfo) {
        this.bizInStockInfoMapper.update(bizInStockInfo);
        return this.queryById(bizInStockInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizInStockInfoMapper.deleteById(id) > 0;
    }
}
