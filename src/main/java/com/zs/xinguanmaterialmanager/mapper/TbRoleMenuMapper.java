package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单关联表(TbRoleMenu)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:44
 */
@Mapper
public interface TbRoleMenuMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRoleMenu queryById(Integer id);

    /**
     * 新增数据
     *
     * @param tbRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(TbRoleMenu tbRoleMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbRoleMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbRoleMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbRoleMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbRoleMenu> entities);

    /**
     * 修改数据
     *
     * @param tbRoleMenu 实例对象
     * @return 影响行数
     */
    int update(TbRoleMenu tbRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

