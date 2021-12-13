package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizInStockInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizInStockInfo)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:27
 */
@Mapper
public interface BizInStockInfoMapper {
//fan
    /**
     * 通过inNum删除入库表info表信息
     * @param inNum
     * @return
     */
    int deleteInfo(String inNum);


    /**
     * 通过inNum查对象
     * @param inNum
     * @return
     */
    List<BizInStockInfo> findByInNum(String inNum);



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizInStockInfo queryById(Long id);

    /**
     * 新增数据
     *
     * @param bizInStockInfo 实例对象
     * @return 影响行数
     */
    int insert(BizInStockInfo bizInStockInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizInStockInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizInStockInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizInStockInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizInStockInfo> entities);

    /**
     * 修改数据
     *
     * @param bizInStockInfo 实例对象
     * @return 影响行数
     */
    int update(BizInStockInfo bizInStockInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

//fan


}

