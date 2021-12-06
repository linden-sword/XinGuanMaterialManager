package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizOutStockInfo;

/**
 * (BizOutStockInfo)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:29
 */
public interface BizOutStockInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizOutStockInfo queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizOutStockInfo 实例对象
     * @return 实例对象
     */
    BizOutStockInfo insert(BizOutStockInfo bizOutStockInfo);

    /**
     * 修改数据
     *
     * @param bizOutStockInfo 实例对象
     * @return 实例对象
     */
    BizOutStockInfo update(BizOutStockInfo bizOutStockInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
