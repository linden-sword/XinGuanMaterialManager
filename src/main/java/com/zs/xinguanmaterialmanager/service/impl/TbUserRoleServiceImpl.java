package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbUserRole;
import com.zs.xinguanmaterialmanager.mapper.TbUserRoleMapper;
import com.zs.xinguanmaterialmanager.service.TbUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色关联表(TbUserRole)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:48
 */
@Service("tbUserRoleService")
public class TbUserRoleServiceImpl implements TbUserRoleService {
    @Resource
    private TbUserRoleMapper tbUserRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUserRole queryById(Integer id) {
        return this.tbUserRoleMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbUserRole insert(TbUserRole tbUserRole) {
        this.tbUserRoleMapper.insert(tbUserRole);
        return tbUserRole;
    }

    /**
     * 修改数据
     *
     * @param tbUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbUserRole update(TbUserRole tbUserRole) {
        this.tbUserRoleMapper.update(tbUserRole);
        return this.queryById(tbUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbUserRoleMapper.deleteById(id) > 0;
    }
}
