package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizOutStock;

/**
 * (BizOutStock)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:28
 */
public interface BizOutStockService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizOutStock queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    BizOutStock insert(BizOutStock bizOutStock);

    /**
     * 修改数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    BizOutStock update(BizOutStock bizOutStock);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
