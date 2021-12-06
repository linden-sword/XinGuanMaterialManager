package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizConsumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizConsumer)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:23
 */
@Mapper
public interface BizConsumerMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizConsumer queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizConsumer 实例对象
     * @return 影响行数
     */
    int insert(BizConsumer bizConsumer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizConsumer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizConsumer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizConsumer> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizConsumer> entities);

    /**
     * 修改数据
     *
     * @param bizConsumer 实例对象
     * @return 影响行数
     */
    int update(BizConsumer bizConsumer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

