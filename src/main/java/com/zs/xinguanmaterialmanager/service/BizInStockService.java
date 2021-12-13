package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizInStock;
import com.zs.xinguanmaterialmanager.entity.BizProduct;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.vo.InStockVO;

/**
 * (BizInStock)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:25
 */
public interface BizInStockService {
//fan
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizInStock queryById(int id);

    /**
     * 新增数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    BizInStock insert(BizInStock bizInStock);

    /**
     * 修改数据
     * 从回收站中恢复数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    int update(long id);

    /**
     * 通过主键删除数据
     *
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);


    /**
     * 移入回收站
     * @param id
     * @return
     */
    Integer remove(long id);

    /**
     * 查询明细
     */
    PageInfo<BizProduct> detail2(long id, int pageNum, int pageSize);

    /**
     * 查询明细头
     */
    BizSupplier detail1(long id);

    /**
     * 通过inNum删除入库表信息
     * @param
     * @return
     */
    Integer delete(long id);


    /**
     * 多条件模糊查询入库信息分页
     * @param inStockVO
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<InStockVO> findInStockList(InStockVO inStockVO, int pageNum, int pageSize);

    /**
     * 入库审核
     * @param bizInStock
     * @return
     */
    Integer publish(long id);
//fan
}
