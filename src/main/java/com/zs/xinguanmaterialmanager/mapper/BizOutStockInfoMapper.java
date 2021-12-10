package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizOutStockInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizOutStockInfo)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:30
 */
@Mapper
public interface BizOutStockInfoMapper {

//fan

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizOutStockInfo queryById(Long id);

    /**
     * @Author yym
     * @Description //TODO 根据out_num查 p_num
     * @Date 2021/12/9 10:22
     * @Param [outNnm]
     */
    List<BizOutStockInfo> queryByOutNum(String outNnm);

    /**
     * @Author yym
     * @Description //TODO 提交物资发放单
     * @Date 2021/12/8 21:21
     * @Param [bizOutStockInfo]
     */
    int insert(BizOutStockInfo bizOutStockInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizOutStockInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizOutStockInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizOutStockInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizOutStockInfo> entities);

    /**
     * 修改数据
     *
     * @param bizOutStockInfo 实例对象
     * @return 影响行数
     */
    int update(BizOutStockInfo bizOutStockInfo);

    /**
     * @Author yym
     * @Description //TODO 根据Id删除
     * @Date 2021/12/9 10:45
     * @Param [id]
     */
    int deleteById(Long id);
//fan
}

