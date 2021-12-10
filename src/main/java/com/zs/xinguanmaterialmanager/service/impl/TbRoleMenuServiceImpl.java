package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbRoleMenu;
import com.zs.xinguanmaterialmanager.mapper.TbRoleMenuMapper;
import com.zs.xinguanmaterialmanager.service.TbRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色菜单关联表(TbRoleMenu)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:44
 */
@Service("tbRoleMenuService")
public class TbRoleMenuServiceImpl implements TbRoleMenuService {
    @Resource
    private TbRoleMenuMapper tbRoleMenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbRoleMenu queryById(Integer id) {
        return this.tbRoleMenuMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbRoleMenu insert(TbRoleMenu tbRoleMenu) {
        this.tbRoleMenuMapper.insert(tbRoleMenu);
        return tbRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbRoleMenu update(TbRoleMenu tbRoleMenu) {
        this.tbRoleMenuMapper.update(tbRoleMenu);
        return this.queryById(tbRoleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbRoleMenuMapper.deleteById(id) > 0;
    }
}
