package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizInStockInfo;

/**
 * (BizInStockInfo)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:26
 */
public interface BizInStockInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizInStockInfo queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizInStockInfo 实例对象
     * @return 实例对象
     */
    BizInStockInfo insert(BizInStockInfo bizInStockInfo);

    /**
     * 修改数据
     *
     * @param bizInStockInfo 实例对象
     * @return 实例对象
     */
    BizInStockInfo update(BizInStockInfo bizInStockInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
