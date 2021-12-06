package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizProductCategory;
import com.zs.xinguanmaterialmanager.mapper.BizProductCategoryMapper;
import com.zs.xinguanmaterialmanager.service.BizProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizProductCategory)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:32
 */
@Service("bizProductCategoryService")
public class BizProductCategoryServiceImpl implements BizProductCategoryService {
    @Resource
    private BizProductCategoryMapper bizProductCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizProductCategory queryById(Long id) {
        return this.bizProductCategoryMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    @Override
    public BizProductCategory insert(BizProductCategory bizProductCategory) {
        this.bizProductCategoryMapper.insert(bizProductCategory);
        return bizProductCategory;
    }

    /**
     * 修改数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    @Override
    public BizProductCategory update(BizProductCategory bizProductCategory) {
        this.bizProductCategoryMapper.update(bizProductCategory);
        return this.queryById(bizProductCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizProductCategoryMapper.deleteById(id) > 0;
    }
}
