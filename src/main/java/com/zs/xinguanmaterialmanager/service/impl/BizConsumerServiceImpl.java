package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizConsumer;
import com.zs.xinguanmaterialmanager.mapper.BizConsumerMapper;
import com.zs.xinguanmaterialmanager.service.BizConsumerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
     * @Author yym
     * @Description //TODO 通过ID查询单条数据
     * @Date 2021/12/6 22:35
     * @Param [id]
     */
    @Override
    public BizConsumer findById(Long id) {
        return this.bizConsumerMapper.findById(id);
    }


    /**
     * @Author yym
     * @Description //TODO 新增物资去处
     * @Date 2021/12/6 22:15
     * @Param [bizConsumer]
     */
    @Override
    public boolean addConsumer(BizConsumer bizConsumer) {
        bizConsumer.setCreateTime(new Date());
        bizConsumer.setModifiedTime(new Date());
        return this.bizConsumerMapper.addConsumer(bizConsumer) > 0;
    }

    /**
     * 修改数据
     *
     * @param bizConsumer 实例对象
     * @return 实例对象
     */
  /*  @Override
    public BizConsumer update(BizConsumer bizConsumer) {
        this.bizConsumerMapper.update(bizConsumer);
        return this.findById(bizConsumer.getId());
    }
*/

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资去向
     * @Date 2021/12/6 22:20
     * @Param [id]
     */
    @Override
    public boolean deleteConsumer(Long id) {
        return this.bizConsumerMapper.deleteConsumer(id) > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 查询所有物资去向信息
     * @Date 2021/12/7 9:19
     * @Param []
     */
    @Override
    public List<BizConsumer> findAllConsumer() {
        List<BizConsumer> consumers = bizConsumerMapper.findAllConsumer();
        return consumers;
    }

    /**
     * @Author yym
     * @Description //TODO 分页查询物资去向信息
     * @Date 2021/12/7 10:24
     * @Param [pageNum, pageSize]
     */
    @Override
    public List<BizConsumer> findAllPageConsumer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizConsumer> consumerList = bizConsumerMapper.findAllConsumer();
        return consumerList;
    }


    /**
     * @Author yym
     * @Description //TODO 物资去向分页信息
     * @Date 2021/12/7 10:29
     * @Param [pageNum, pageSize]
     */
    public PageInfo<BizConsumer> findAllPageInfoConsumer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizConsumer> consumerList = bizConsumerMapper.findAllConsumer();
        PageInfo<BizConsumer> pageInfo = new PageInfo<BizConsumer>(consumerList);
        return pageInfo;
    }

    /**
     * @Author yym
     * @Description //TODO 根据条件模糊查询
     * @Date 2021/12/7 10:40
     * @Param [pageNum, pageSize, bizConsumer]
     */
    @Override
    public PageInfo<BizConsumer> findConsumerList(int pageNum, int pageSize, BizConsumer bizConsumer) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizConsumer> consumerList = bizConsumerMapper.findConsumerList(bizConsumer);
        PageInfo<BizConsumer> pageInfo = new PageInfo<BizConsumer>(consumerList);
        return pageInfo;
    }

    /**
     * @Author yym
     * @Description //TODO 根据ID更新物资去处信息
     * @Date 2021/12/7 11:52
     * @Param [id, bizConsumer]
     */
    @Override
    public boolean updateConsumer(Long id, BizConsumer bizConsumer) {
        bizConsumer.setId(id);
        Date date = new Date();
        bizConsumer.setModifiedTime(date);
        return bizConsumerMapper.updateConsumer(bizConsumer) > 0;

    }
}
