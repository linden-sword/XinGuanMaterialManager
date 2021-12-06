package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizHealth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizHealth)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:24
 */
@Mapper
public interface BizHealthMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizHealth queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizHealth 实例对象
     * @return 影响行数
     */
    int insert(BizHealth bizHealth);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizHealth> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizHealth> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizHealth> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizHealth> entities);

    /**
     * 修改数据
     *
     * @param bizHealth 实例对象
     * @return 影响行数
     */
    int update(BizHealth bizHealth);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

