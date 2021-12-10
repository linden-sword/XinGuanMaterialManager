package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizProduct;
import com.zs.xinguanmaterialmanager.mapper.BizProductMapper;
import com.zs.xinguanmaterialmanager.service.BizProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizProduct)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:31
 */
@Service("bizProductService")
public class BizProductServiceImpl implements BizProductService {
    @Resource
    private BizProductMapper bizProductMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public BizProduct queryById(Long id) {
        return this.bizProductMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BizProduct insert(BizProduct bizProduct) {
        this.bizProductMapper.insert(bizProduct);
        return bizProduct;
    }

    /**
     * 修改数据
     *
     * @param bizProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BizProduct update(BizProduct bizProduct) {
        this.bizProductMapper.update(bizProduct);
        return this.queryById(bizProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizProductMapper.deleteById(id) > 0;
    }
}
