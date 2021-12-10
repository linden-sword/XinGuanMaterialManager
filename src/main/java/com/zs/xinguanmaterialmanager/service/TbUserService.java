package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbRole;
import com.zs.xinguanmaterialmanager.entity.TbUser;

import java.util.List;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:47
 */
public interface TbUserService {

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
     * @return 实例对象
     */
    int insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询用户已有角色(从user_role里面查所有的roleID，然后去role表里查对应的role)
     *
     * @param id
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbRole>
     * @author Zanson
     * @since 17:07 2021/12/7
     **/
    List<TbRole> findUserRoles(Long id);

}
