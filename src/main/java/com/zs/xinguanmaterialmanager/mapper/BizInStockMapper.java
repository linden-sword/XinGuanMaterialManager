package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizInStock;
import com.zs.xinguanmaterialmanager.vo.InStockVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizInStock)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:26
 */
@Mapper
public interface BizInStockMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizInStock queryById(int id);

    /**
     *通过id或inNum查询入库表信息
     */
    List<BizInStock> findInStock(BizInStock bizInStock);
//fan
    /**
     * 新增数据
     *
     * @param bizInStock 实例对象
     * @return 影响行数
     */
    int insert(BizInStock bizInStock);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizInStock> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizInStock> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizInStock> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizInStock> entities);

    /**
     * 修改数据
     *
     * @param bizInStock 实例对象
     * @return 影响行数
     */
    int update(BizInStock bizInStock);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

    /**
     * 通过inNUM删除入库表信息
     */
    int deleteInStock(String inNum);

    /**
     * 多条件模糊查询信息
     */
    List<InStockVO> findInStockList(InStockVO inStockVO);
//fan
}

