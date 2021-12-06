package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizInStock;

/**
 * (BizInStock)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:25
 */
public interface BizInStockService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizInStock queryById(Object id);

    /**
     * 新增数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    BizInStock insert(BizInStock bizInStock);

    /**
     * 修改数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    BizInStock update(BizInStock bizInStock);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);

}
