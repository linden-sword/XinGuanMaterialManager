package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbMenu;

import java.util.List;
import java.util.Map;

/**
 * 菜单表(TbMenu)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:41
 */
public interface TbMenuService {

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
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
     * @author Zanson
     * @since 10:49 2021/12/7
     **/
    List<TbMenu> queryAll();

    /**
     * 根据上级菜单ID查询权限列表
     *
     * @param parentId
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
     * @author Zanson
     * @since 11:12 2021/12/7
     **/
    List<TbMenu> queryByParentId(Long parentId);

//    //加载菜单树(实体类添加一个List属性)
//    Map<String,List<TbMenu>> queryMenuTree();

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    int insert(TbMenu tbMenu);

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    int update(TbMenu tbMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
