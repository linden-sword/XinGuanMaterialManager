package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizHealth;
import com.zs.xinguanmaterialmanager.mapper.BizHealthMapper;
import com.zs.xinguanmaterialmanager.service.BizHealthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizHealth)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:24
 */
@Service("bizHealthService")
public class BizHealthServiceImpl implements BizHealthService {
    @Resource
    private BizHealthMapper bizHealthMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizHealth queryById(Long id) {
        return this.bizHealthMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizHealth 实例对象
     * @return 实例对象
     */
    @Override
    public BizHealth insert(BizHealth bizHealth) {
        this.bizHealthMapper.insert(bizHealth);
        return bizHealth;
    }

    /**
     * 修改数据
     *
     * @param bizHealth 实例对象
     * @return 实例对象
     */
    @Override
    public BizHealth update(BizHealth bizHealth) {
        this.bizHealthMapper.update(bizHealth);
        return this.queryById(bizHealth.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizHealthMapper.deleteById(id) > 0;
    }
}
