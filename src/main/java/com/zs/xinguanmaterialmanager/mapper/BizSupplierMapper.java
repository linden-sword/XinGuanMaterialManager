package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizSupplier)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:35
 */
@Mapper
public interface BizSupplierMapper {
//fan
    /**
     * 通过ID查询
     *
     * @param id 主键
     * @return 实例对象
     */
    BizSupplier queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizSupplier 实例对象
     * @return 影响行数
     */
    int insert(BizSupplier bizSupplier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizSupplier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizSupplier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizSupplier> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizSupplier> entities);

    /**
     * 修改数据
     *
     * @param bizSupplier 实例对象
     * @return 影响行数
     */
    int update(BizSupplier bizSupplier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    /**
     *所有来源
     * @return
     */
    List<BizSupplier> findAll();

    /**
     * 根据来源名 模糊 查询
     * @param
     * @return
     */
    List<BizSupplier> findSupplierList(BizSupplier bizSupplier);

//fan
}

