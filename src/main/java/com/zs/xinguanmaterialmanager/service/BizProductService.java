package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizProduct;

import java.util.List;

/**
 * (BizProduct)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:30
 */
public interface BizProductService {

    /**
     * @Author yym
     * @Description //TODO 跟ID查询一条物资数据（编辑回显）
     * @Date 2021/12/7 16:35
     * @Param [id]
     */
    BizProduct editProuductById(Long id);

    /**
     * @Author yym
     * @Description //TODO 添加物资数据
     * @Date 2021/12/7 16:10
     * @Param [bizProduct]
     */
    boolean addProuduct(BizProduct bizProduct) throws Exception;

    /**
     * 修改数据
     *
     * @param bizProduct 实例对象
     * @return 实例对象
     */
    BizProduct update(BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资
     * @Date 2021/12/7 16:26
     * @Param [id]
     */
    boolean deleteProuductById(Long id);

    /**
     * @Author yym
     * @Description //TODO 从回收站回复物资
     * @Date 2021/12/7 16:23
     * @Param [id]
     */
    boolean backProuduct(Long id);

    /**
     * @Author yym
     * @Description //TODO 物资所有库存信息,饼图使用
     * @Date 2021/12/7 17:29
     * @Param [pageNum, pageSize]
     */
    List<BizProduct> findAllStocks(Integer pageNum, Integer pageSize);

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询
     * @Date 2021/12/7 19:50
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    PageInfo<BizProduct> findProductList(Integer pageNum, Integer pageSize, BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询(物资库存)
     * @Date 2021/12/7 20:21
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    PageInfo<BizProduct> findProductStocks(Integer pageNum, Integer pageSize, BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 根据物资名模糊查询(可入库物资列表)
     * @Date 2021/12/7 21:10
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    PageInfo<BizProduct> findProducts(Integer pageNum, Integer pageSize, BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 添加物资审核
     * @Date 2021/12/8 10:16
     * @Param [id]
     */
    boolean auditProducts(Long id);

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/8 10:35
     * @Param [id]
     */
    boolean removeProducts(Long id);

    /**
     * @Author yym
     * @Description //TODO 更新物资信息
     * @Date 2021/12/8 11:11
     * @Param [id, bizProduct]
     */
    boolean updateProducts(Long id, BizProduct bizProduct);
}
