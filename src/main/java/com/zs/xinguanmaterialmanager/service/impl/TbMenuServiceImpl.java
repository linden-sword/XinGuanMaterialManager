package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbMenu;
import com.zs.xinguanmaterialmanager.mapper.TbMenuMapper;
import com.zs.xinguanmaterialmanager.service.TbMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 菜单表(TbMenu)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:42
 */
@Service("tbMenuService")
public class TbMenuServiceImpl implements TbMenuService {
    @Resource
    private TbMenuMapper tbMenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbMenu queryById(Long id) {
        return this.tbMenuMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbMenu insert(TbMenu tbMenu) {
        this.tbMenuMapper.insert(tbMenu);
        return tbMenu;
    }

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    @Override
    public TbMenu update(TbMenu tbMenu) {
        this.tbMenuMapper.update(tbMenu);
        return this.queryById(tbMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbMenuMapper.deleteById(id) > 0;
    }
}
