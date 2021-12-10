package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbRole;
import com.zs.xinguanmaterialmanager.entity.TbUser;
import com.zs.xinguanmaterialmanager.entity.TbUserRole;
import com.zs.xinguanmaterialmanager.mapper.TbRoleMapper;
import com.zs.xinguanmaterialmanager.mapper.TbUserMapper;
import com.zs.xinguanmaterialmanager.mapper.TbUserRoleMapper;
import com.zs.xinguanmaterialmanager.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

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
