package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbRoleMenu;

/**
 * 角色菜单关联表(TbRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:44
 */
public interface TbRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    TbRoleMenu queryById(Integer id);

    /**
     * 新增数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    TbRoleMenu insert(TbRoleMenu tbRoleMenu);

    /**
     * 修改数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    TbRoleMenu update(TbRoleMenu tbRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
