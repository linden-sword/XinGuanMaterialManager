package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.*;
import com.zs.xinguanmaterialmanager.mapper.*;
import com.zs.xinguanmaterialmanager.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:47
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;
    @Resource
    private TbUserRoleMapper tbUserRoleMapper;
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
    public TbUser queryById(Long id) {
        return this.tbUserMapper.queryById(id);
    }

    /**
     * 通过username查询user
     *
     * @param username
     * @return com.zs.xinguanmaterialmanager.entity.TbUser
     * @author Zanson
     * @since 16:46 2021/12/9
     **/
    @Override
    public TbUser findByUsername(String username) {
        return tbUserMapper.findByUsername(username);
    }

    /**
     * 新增UserRole
     *
     * @param userId, roleId
     * @return int
     * @author Zanson
     * @since 17:16 2021/12/10
     **/
    @Override
    public int insertUserRole(Long userId, Long roleId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        return tbUserRoleMapper.insertUserRole(map);
    }

    /**
     * 分页模糊查询二合一
     *
     * @param tbUser
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbUser>
     * @author Zanson
     * @since 15:38 2021/12/7
     **/
    @Override
    public List<TbUser> findUserList(TbUser tbUser) {
        return tbUserMapper.findUserList(tbUser);
    }

    /**
     * 加载菜单(通过用户查询菜单树)(登录后 : 加载当前用户的菜单树)
     *
     * @param tbUserId
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
     * @author Zanson
     * @since 16:08 2021/12/10
     **/
    @Override
    public List<TbMenu> findMenu(Long tbUserId) {
        List<TbMenu> menuList11 = new ArrayList<>();
        //根据userID在user_role获取RoleID，然后在Role_menu获取menu
        List<TbUserRole> userRoleList = tbUserRoleMapper.queryUserRoleByUserId(tbUserId);
        for (TbUserRole userRole : userRoleList) {
            List<TbRoleMenu> roleMenuList = tbRoleMenuMapper.queryByRoleId(userRole.getRoleId());
            for (TbRoleMenu roleMenu : roleMenuList) {
                TbMenu menu = tbMenuMapper.queryById(roleMenu.getMenuId());
                menuList11.add(menu);
            }
        }
        return menuList11;
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(TbUser tbUser) {
        return this.tbUserMapper.insert(tbUser);
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TbUser tbUser) {
        return this.tbUserMapper.update(tbUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbUserMapper.deleteById(id) > 0;
    }


    /**
     * 查询用户已有角色(从user_role里面查所有的roleID，然后去role表里查对应的role)
     *
     * @param id
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbRole>
     * @author Zanson
     * @since 17:07 2021/12/7
     **/
    @Override
    public List<TbRole> findUserRoles(Long id) {
        //从user_role里面查所有的roleID，然后去role表里查对应的role
        List<TbUserRole> userRoleList = tbUserRoleMapper.queryUserRoleByUserId(id);

        List<TbRole> roleList = new ArrayList<>();
        for (TbUserRole userRole : userRoleList) {
            TbRole role = tbRoleMapper.queryById(userRole.getRoleId());
            roleList.add(role);
        }
        System.out.println("///===FindRoleListByUserId(Service):" + roleList);
        return roleList;
    }
}
