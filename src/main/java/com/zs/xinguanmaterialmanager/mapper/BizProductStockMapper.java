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
     * @Author yym
     * @Description //TODO 根据pNum查询物资总数
     * @Date 2021/12/8 20:59
     * @Param [pNum]
     */
    BizProductStock queryBypNum(String pNum);

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
     * @Author yym
     * @Description //TODO 提交物资发放单是更新库存数据
     * @Date 2021/12/8 21:24
     * @Param [bizProductStock]
     */
    int update(BizProductStock bizProductStock);

    int deleteById(Long id);

    /**
     * @Author yym
     * @Description //TODO 删除库存中的物资
     * @Date 2021/12/8 15:57
     * @Param [pNum]
     */
    int deleteBypNum(String pNum);

}

