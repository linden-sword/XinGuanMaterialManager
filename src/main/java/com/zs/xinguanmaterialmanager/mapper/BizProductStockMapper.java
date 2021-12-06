package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizProductStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizProductStock)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:34
 */
@Mapper
public interface BizProductStockMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizProductStock queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizProductStock 实例对象
     * @return 影响行数
     */
    int insert(BizProductStock bizProductStock);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizProductStock> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizProductStock> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizProductStock> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizProductStock> entities);

    /**
     * 修改数据
     *
     * @param bizProductStock 实例对象
     * @return 影响行数
     */
    int update(BizProductStock bizProductStock);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

