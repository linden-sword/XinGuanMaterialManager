package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizProduct)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:31
 */
@Mapper
public interface BizProductMapper {
//fan
    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    BizProduct queryById(Long id);

    /**
     * @Author yym
     * @Description //TODO 跟ID查询一条物资数据（编辑回显）
     * @Date 2021/12/7 16:35
     * @Param [id]
     */
    BizProduct editProuductById(Long id);

    /**
     * 通过pNum
     *
     * @param pNum
     * @return 实例对象
     */
    List<BizProduct> queryBypNum(String pNum);



    /**
     * 新增数据
     *
     * @param bizProduct 实例对象
     * @return 影响行数
     */
    int insert(BizProduct bizProduct);


    /**
     * @Author yym
     * @Description //TODO 添加物资数据
     * @Date 2021/12/7 16:10
     * @Param [bizProduct]
     */
    int addProuduct(BizProduct bizProduct);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizProduct> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizProduct> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizProduct> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizProduct> entities);

    /**
     * 修改数据
     *
     * @param bizProduct 实例对象
     * @return 影响行数
     */
    int update(BizProduct bizProduct);

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过inNum删除数据
     *
     * @param inNum
     * @return 影响行数
     */
    int deleteInStock(String inNum);
//fan


    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资
     * @Date 2021/12/7 16:26
     * @Param [id]
     */
    int deleteProuductById(Long id);

    /**
     * @Author yym
     * @Description //TODO 从回收站回复物资
     * @Date 2021/12/7 16:15
     * @Param [id]
     */
    int backProuduct(Long id);

    /**
     * @Author yym
     * @Description //TODO 物资所有库存信息,饼图使用
     * @Date 2021/12/7 17:29
     * @Param [pageNum, pageSize]
     */
    List<BizProduct> findAllStocks();

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询
     * @Date 2021/12/7 19:50
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    List<BizProduct> findProductList(BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询(物资库存)
     * @Date 2021/12/7 20:21
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    List<BizProduct> findProductStocks(BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 根据物资名模糊查询(可入库物资列表)
     * @Date 2021/12/7 21:10
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    List<BizProduct> findProducts(BizProduct bizProduct);

    /**
     * @Author yym
     * @Description //TODO 添加物资审核
     * @Date 2021/12/8 10:16
     * @Param [id]
     */
    int auditProducts(Long id);

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/8 10:35
     * @Param [id]
     */
    int removeProducts(Long id);

    /**
     * @Author yym
     * @Description //TODO 更新物资信息
     * @Date 2021/12/8 11:11
     * @Param [id, bizProduct]
     */
    int updateProducts(BizProduct bizProduct);


    /**
     * @Author yym
     * @Description //TODO 发放单明细
     * @Date 2021/12/9 16:03
     * @Param [bizOutStock]
     */
    List<BizProduct> detailOutStock(BizOutStock bizOutStock);

}

