package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.BizConsumer;
import com.zs.xinguanmaterialmanager.mapper.BizConsumerMapper;
import com.zs.xinguanmaterialmanager.service.BizConsumerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BizConsumer)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:23
 */
@Service("bizConsumerService")
public class BizConsumerServiceImpl implements BizConsumerService {
    @Resource
    private BizConsumerMapper bizConsumerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizConsumer queryById(Long id) {
        return this.bizConsumerMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizConsumer 实例对象
     * @return 实例对象
     */
    @Override
    public BizConsumer insert(BizConsumer bizConsumer) {
        this.bizConsumerMapper.insert(bizConsumer);
        return bizConsumer;
    }

    /**
     * 修改数据
     *
     * @param bizConsumer 实例对象
     * @return 实例对象
     */
    @Override
    public BizConsumer update(BizConsumer bizConsumer) {
        this.bizConsumerMapper.update(bizConsumer);
        return this.queryById(bizConsumer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bizConsumerMapper.deleteById(id) > 0;
    }
}
