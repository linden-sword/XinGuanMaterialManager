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
     * @Author yym
     * @Description //TODO 通过ID查询单条数据
     * @Date 2021/12/6 22:35
     * @Param [id]
     */
    BizConsumer findById(Long id);

    /**
     * @Author yym
     * @Description //TODO 新增物资去处
     * @Date 2021/12/6 22:15
     * @Param [bizConsumer]
     */
    int addConsumer(BizConsumer bizConsumer);

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
     * @Author yym
     * @Description //TODO 根据ID更新物资去处信息
     * @Date 2021/12/7 11:52
     * @Param [id, bizConsumer]
     */
    int updateConsumer(BizConsumer bizConsumer);

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资去向
     * @Date 2021/12/6 22:20
     * @Param [id]
     */
    int deleteConsumer(Long id);

    /**
     * @Author yym
     * @Description //TODO 查询所有的物资去向信息
     * @Date 2021/12/7 9:21
     * @Param []
     */
    List<BizConsumer> findAllConsumer();

    /**
     * @Author yym
     * @Description //TODO 根据条件模糊查询
     * @Date 2021/12/7 10:47
     * @Param [bizConsumer]
     */
    List<BizConsumer> findConsumerList(BizConsumer bizConsumer);

}

