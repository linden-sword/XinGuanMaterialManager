package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单表(TbMenu)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:42
 */
@Mapper
public interface TbMenuMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbMenu queryById(Long id);

    /**
     * 查询所有权限
     *
     * @author Zanson
     * @since 10:49 2021/12/7
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
    **/
    List<TbMenu> queryAll();

    /**
     * 根据上级菜单ID查询权限列表
     *
     * @author Zanson
     * @since 11:12 2021/12/7
     * @param parentId
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
    **/
    List<TbMenu> queryByParentId(Long parentId);

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 影响行数
     */
    int insert(TbMenu tbMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbMenu> entities);

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 影响行数
     */
    int update(TbMenu tbMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

