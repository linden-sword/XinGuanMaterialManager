package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizProduct;

/**
 * (BizProduct)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:30
 */
public interface BizProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizProduct queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizProduct 实例对象
     * @return 实例对象
     */
    BizProduct insert(BizProduct bizProduct);

    /**
     * 修改数据
     *
     * @param bizProduct 实例对象
     * @return 实例对象
     */
    BizProduct update(BizProduct bizProduct);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
