package com.zs.xinguanmaterialmanager.mapper;

import com.zs.xinguanmaterialmanager.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(TbUser)表数据库访问层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:47
 */
@Mapper
public interface TbUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(Long id);

    /**
     * 通过username查询user
     *
     * @param username
     * @return com.zs.xinguanmaterialmanager.entity.TbUser
     * @author Zanson
     * @since 16:44 2021/12/9
     **/
    TbUser findByUsername(String username);

    /**
     * 分页模糊查询二合一
     *
     * @param tbUser
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbUser>
     * @author Zanson
     * @since 15:33 2021/12/7
     **/
    List<TbUser> findUserList(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbUser> entities);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

