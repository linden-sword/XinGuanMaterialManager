package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbRole;
import com.zs.xinguanmaterialmanager.mapper.TbRoleMapper;
import com.zs.xinguanmaterialmanager.service.TbRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbRole insert(TbRole tbRole) {
        this.tbRoleMapper.insert(tbRole);
        return tbRole;
    }

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbRole update(TbRole tbRole) {
        this.tbRoleMapper.update(tbRole);
        return this.queryById(tbRole.getId());
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
