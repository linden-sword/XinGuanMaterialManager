package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.BizProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BizProductCategory)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:32
 */
@Mapper
public interface BizProductCategoryMapper {
//fan
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizProductCategory queryById(Long id);

    /**
     * 查询所有
     * @return
     */
    List<BizProductCategory> findAll();
    List<BizProductCategory> findAll1();

    /**
     * 查询父级下的所有子级
     * @param pid
     * @return
     */
    List<BizProductCategory> findAllByPid(Long pid);
    /**
     * 新增数据
     *
     * @param bizProductCategory 实例对象
     * @return 影响行数
     */
    int insert(BizProductCategory bizProductCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizProductCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BizProductCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BizProductCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BizProductCategory> entities);

    /**
     * 修改数据
     *
     * @param bizProductCategory 实例对象
     * @return 影响行数
     */
    int update(BizProductCategory bizProductCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据id查询pid
     * @param id
     * @return
     */
    List<BizProductCategory> findById(long id);

    List<BizProductCategory> selectList();

    List<BizProductCategory> listWithTree();


    //fan
}

