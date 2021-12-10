package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizHealth;

/**
 * (BizHealth)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:24
 */
public interface BizHealthService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizHealth queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizHealth 实例对象
     * @return 实例对象
     */
    BizHealth insert(BizHealth bizHealth);

    /**
     * 修改数据
     *
     * @param bizHealth 实例对象
     * @return 实例对象
     */
    BizHealth update(BizHealth bizHealth);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
