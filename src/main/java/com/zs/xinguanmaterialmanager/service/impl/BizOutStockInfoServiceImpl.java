package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizOutStockInfo;
import com.zs.xinguanmaterialmanager.mapper.BizOutStockInfoMapper;
import com.zs.xinguanmaterialmanager.service.BizOutStockInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizOutStockInfo)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:29
 */
@Service("bizOutStockInfoService")
public class BizOutStockInfoServiceImpl implements BizOutStockInfoService {
    @Resource
    private BizOutStockInfoMapper bizOutStockInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizOutStockInfo queryById(Long id) {
        return this.bizOutStockInfoMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizOutStockInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BizOutStockInfo insert(BizOutStockInfo bizOutStockInfo) {
        this.bizOutStockInfoMapper.insert(bizOutStockInfo);
        return bizOutStockInfo;
    }

    /**
     * 修改数据
     *
     * @param bizOutStockInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BizOutStockInfo update(BizOutStockInfo bizOutStockInfo) {
        this.bizOutStockInfoMapper.update(bizOutStockInfo);
        return this.queryById(bizOutStockInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizOutStockInfoMapper.deleteById(id) > 0;
    }
}
