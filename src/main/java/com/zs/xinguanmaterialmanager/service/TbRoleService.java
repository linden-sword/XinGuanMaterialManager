package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbRole;

import java.util.List;

/**
 * 角色表(TbRole)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:43
 */
public interface TbRoleService {

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
     * @return 实例对象
     */
    int insert(TbRole tbRole);

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    int update(TbRole tbRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
