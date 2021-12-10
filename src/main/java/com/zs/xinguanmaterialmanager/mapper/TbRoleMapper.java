package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(TbRole)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:43
 */
@Mapper
public interface TbRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRole queryById(Long id);

    /**
     * 模糊分页查询二合一
     *
     * @param tbRole
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbRole>
     * @author Zanson
     * @since 21:59 2021/12/7
     **/
    List<TbRole> queryAll(TbRole tbRole);

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 影响行数
     */
    int insert(TbRole tbRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbRole> entities);

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 影响行数
     */
    int update(TbRole tbRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

