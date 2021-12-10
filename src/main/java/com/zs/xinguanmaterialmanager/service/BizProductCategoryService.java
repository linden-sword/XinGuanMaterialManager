package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizProductCategory;

/**
 * (BizProductCategory)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:32
 */
public interface BizProductCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizProductCategory queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    BizProductCategory insert(BizProductCategory bizProductCategory);

    /**
     * 修改数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    BizProductCategory update(BizProductCategory bizProductCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
