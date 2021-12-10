package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizOutStock;
import com.zs.xinguanmaterialmanager.entity.DetailOutStock;
import com.zs.xinguanmaterialmanager.entity.outStockVO;

/**
 * (BizOutStock)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:28
 */
public interface BizOutStockService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    BizOutStock queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    BizOutStock insert(BizOutStock bizOutStock);

    /**
     * 修改数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    BizOutStock update(BizOutStock bizOutStock);

    /**
     * @Author yym
     * @Description //TODO 通过ID删除物资发放单
     * @Date 2021/12/9 9:57
     * @Param [id]
     */
    boolean deleteOutStock(Long id);

    /**
     * @Author yym
     * @Description //TODO 提交发放单
     * @Date 2021/12/8 21:33
     * @Param [outStockVO]
     */
    boolean addOutStock(outStockVO outStockVO);

    /**
     * @Author yym
     * @Description //TODO 从回收站恢复数据
     * @Date 2021/12/9 9:27
     * @Param [id]
     */
    boolean backOutStock(Long id);

    /**
     * @Author yym
     * @Description //TODO 查询出单列表
     * @Date 2021/12/9 10:56
     * @Param [pageNum, pageSize, bizOutStock]
     */
    PageInfo<BizOutStock> findOutStockList(Integer pageNum, Integer pageSize, BizOutStock bizOutStock);

    /**
     * @Author yym
     * @Description //TODO 审核出库单
     * @Date 2021/12/9 12:15
     * @Param [id]
     */
    boolean auditOutStock(Long id);

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/9 14:36
     * @Param [id]
     */
    boolean removeOutStock(Long id);

    /**
     * @Author yym
     * @Description //TODO 发放单明细
     * @Date 2021/12/9 16:03
     * @Param [id, pageNum, pageSize]
     */
    DetailOutStock detailOutStock(Long id, Integer pageNum, Integer pageSize);
}
