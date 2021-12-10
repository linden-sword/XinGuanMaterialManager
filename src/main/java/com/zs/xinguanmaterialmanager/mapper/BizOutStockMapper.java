package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizOutStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizOutStock)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:28
 */
@Mapper
public interface BizOutStockMapper {

    /**
     * @Author yym
     * @Description //TODO 根据ID查询单条数据
     * @Date 2021/12/9 10:19
     * @Param [id]
     */
    BizOutStock queryById(Long id);

    /**
     * @Author yym
     * @Description //TODO 提交物资发放单
     * @Date 2021/12/8 21:24
     * @Param [bizOutStock]
     */
    int addOutStock(BizOutStock bizOutStock);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizOutStock> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizOutStock> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizOutStock> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizOutStock> entities);

    /**
     * 修改数据
     *
     * @param bizOutStock 实例对象
     * @return 影响行数
     */
    int update(BizOutStock bizOutStock);

    /**
     * @Author yym
     * @Description //TODO 通过ID删除物资发放单
     * @Date 2021/12/9 9:57
     * @Param [id]
     */
    int deleteOutStock(Long id);


    /**
     * @Author yym
     * @Description //TODO 从回收站恢复数据
     * @Date 2021/12/9 9:27
     * @Param [id]
     */
    int backOutStock(Long id);

    /**
     * @Author yym
     * @Description //TODO 查询出单列表
     * @Date 2021/12/9 10:56
     * @Param [pageNum, pageSize, bizOutStock]
     */
    List<BizOutStock> findOutStockList(BizOutStock bizOutStock);

    /**
     * @Author yym
     * @Description //TODO 审核出库单
     * @Date 2021/12/9 12:15
     * @Param [id]
     */
    int auditOutStock(Long id);

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/9 14:36
     * @Param [id]
     */
    int removeOutStock(Long id);
    
}

