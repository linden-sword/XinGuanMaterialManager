package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.BizConsumer;

/**
 * (BizConsumer)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:22
 */
public interface BizConsumerService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    BizConsumer queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizConsumer 实例对象
     * @return 实例对象
     */
    BizConsumer insert(BizConsumer bizConsumer);

    /**
     * 修改数据
     *
     * @param bizConsumer 实例对象
     * @return 实例对象
     */
    BizConsumer update(BizConsumer bizConsumer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
