package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户角色关联表(TbUserRole)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:48
 */
@Mapper
public interface TbUserRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUserRole queryById(Integer id);

    /**
     * 通过userID查询userRole
     *
     * @param id
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbUserRole>
     * @author Zanson
     * @since 17:11 2021/12/7
     **/
    List<TbUserRole> queryUserRoleByUserId(Long id);

    /**
     * 新增数据
     *
     * @param tbUserRole 实例对象
     * @return 影响行数
     */
    int insert(TbUserRole tbUserRole);

    /**
     * 新增UserRole
     *
     * @author Zanson
     * @since 17:11 2021/12/10
     * @param map
     * @return int
    **/
    int insertUserRole(Map<String,Object> map);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbUserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUserRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbUserRole> entities);

    /**
     * 修改数据
     *
     * @param tbUserRole 实例对象
     * @return 影响行数
     */
    int update(TbUserRole tbUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

