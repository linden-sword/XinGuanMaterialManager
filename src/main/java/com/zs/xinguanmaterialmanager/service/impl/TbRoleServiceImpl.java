package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbMenu;
import com.zs.xinguanmaterialmanager.entity.TbRole;
import com.zs.xinguanmaterialmanager.entity.TbRoleMenu;
import com.zs.xinguanmaterialmanager.mapper.TbMenuMapper;
import com.zs.xinguanmaterialmanager.mapper.TbRoleMapper;
import com.zs.xinguanmaterialmanager.mapper.TbRoleMenuMapper;
import com.zs.xinguanmaterialmanager.service.TbRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色表(TbRole)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:43
 */
@Service("tbRoleService")
public class TbRoleServiceImpl implements TbRoleService {
    @Resource
    private TbRoleMapper tbRoleMapper;
    @Resource
    private TbRoleMenuMapper tbRoleMenuMapper;
    @Resource
    private TbMenuMapper tbMenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbRole queryById(Long id) {
        return this.tbRoleMapper.queryById(id);
    }

    /**
     * 根据角色查询角色的权限
     *
     * @author Zanson
     * @since 15:34 2021/12/10
     * @param roleId
     * @return com.zs.xinguanmaterialmanager.entity.TbMenu
    **/
    @Override
    public List<TbMenu> queryMenuByRoleId(Long roleId) {
        List<TbRoleMenu> tbRoleMenu = tbRoleMenuMapper.queryByRoleId(roleId);
        List<TbMenu> menuList = new ArrayList<>();
        for (TbRoleMenu tbRoleMenu1:tbRoleMenu){
            TbMenu tbMenu = tbMenuMapper.queryById(tbRoleMenu1.getMenuId());
            menuList.add(tbMenu);
        }
        return menuList;
    }

    /**
     * 授权
     *
     * @author Zanson
     * @since 15:13 2021/12/10
     * @param roleId, menuId
     * @return int
    **/
    @Override
    public int addRoleMenu(Long roleId, Long menuId) {
        Map<String,Object> map = new HashMap<>();
        map.put("roleId",roleId);
        map.put("menuId",menuId);
        return tbRoleMenuMapper.insertRoleMenu(map);
    }

    /**
     * 分页模糊查询二合一
     *
     * @param tbRole
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbRole>
     * @author Zanson
     * @since 22:03 2021/12/7
     **/
    @Override
    public List<TbRole> queryAll(TbRole tbRole) {
        return tbRoleMapper.queryAll(tbRole);
    }

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(TbRole tbRole) {
        return this.tbRoleMapper.insert(tbRole);
    }

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TbRole tbRole) {
        return this.tbRoleMapper.update(tbRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbRoleMapper.deleteById(id) > 0;
    }
}
