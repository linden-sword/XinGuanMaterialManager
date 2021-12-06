package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizProductStock;

/**
 * (BizProductStock)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:33
 */
public interface BizProductStockService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizProductStock queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizProductStock 实例对象
     * @return 实例对象
     */
    BizProductStock insert(BizProductStock bizProductStock);

    /**
     * 修改数据
     *
     * @param bizProductStock 实例对象
     * @return 实例对象
     */
    BizProductStock update(BizProductStock bizProductStock);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
