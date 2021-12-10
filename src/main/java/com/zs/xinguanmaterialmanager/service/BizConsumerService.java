package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizConsumer;

import java.util.List;

/**
 * (BizConsumer)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:22
 */
public interface BizConsumerService {

    /**
     * @Author yym
     * @Description //TODO 通过ID查询单条数据
     * @Date 2021/12/6 22:35
     * @Param [id]
     */
    BizConsumer findById(Long id);

    /**
     * @Author yym
     * @Description //TODO 新增物资去处
     * @Date 2021/12/6 22:07
     * @Param [bizConsumer]
     */
    boolean addConsumer(BizConsumer bizConsumer);

    /**
     * 修改数据
     *
     * @param bizConsumer 实例对象
     * @return 实例对象
     */
    // BizConsumer update(BizConsumer bizConsumer);

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资去向
     * @Date 2021/12/6 22:20
     * @Param [id]
     */
    boolean deleteConsumer(Long id);

    /**
     * @Author yym
     * @Description //TODO 查询所有物资去向信息
     * @Date 2021/12/7 9:18
     * @Param []
     */
    List<BizConsumer> findAllConsumer();

    /**
     * @Author yym
     * @Description //TODO 分页查询物资去向信息
     * @Date 2021/12/7 10:11
     * @Param []
     */
    List<BizConsumer> findAllPageConsumer(int pageNum, int pageSize);

    /**
     * @Author yym
     * @Description //TODO 物资去向分页信息
     * @Date 2021/12/7 10:29
     * @Param [pageNum, pageSize]
     */
    PageInfo<BizConsumer> findAllPageInfoConsumer(int pageNum, int pageSize);

    /**
     * @Author yym
     * @Description //TODO 根据条件模糊查询物资去处信息
     * @Date 2021/12/7 11:52
     * @Param [pageNum, pageSize, bizConsumer]
     */
    PageInfo<BizConsumer> findConsumerList(int pageNum, int pageSize, BizConsumer bizConsumer);

    /**
     * @Author yym
     * @Description //TODO 根据ID更新物资去处信息
     * @Date 2021/12/7 11:52
     * @Param [id, bizConsumer]
     */
    boolean updateConsumer(Long id, BizConsumer bizConsumer);
}
