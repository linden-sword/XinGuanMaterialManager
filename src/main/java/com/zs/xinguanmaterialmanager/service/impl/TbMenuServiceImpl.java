package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbMenu;
import com.zs.xinguanmaterialmanager.mapper.TbMenuMapper;
import com.zs.xinguanmaterialmanager.service.TbMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
     * 查询所有权限
     *
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
     * @author Zanson
     * @since 10:53 2021/12/7
     **/
    @Override
    public List<TbMenu> queryAll() {
        return tbMenuMapper.queryAll();
    }

    /**
     * 根据上级菜单ID查询权限列表
     *
     * @param parentId
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
     * @author Zanson
     * @since 11:16 2021/12/7
     **/
    @Override
    public List<TbMenu> queryByParentId(Long parentId) {
        return tbMenuMapper.queryByParentId(parentId);
    }

//    //加载菜单树(实体类添加一个List属性)
//    @Override
//    public Map<String, List<TbMenu>> queryMenuTree() {
//        return null;
//    }

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(TbMenu tbMenu) {
        return this.tbMenuMapper.insert(tbMenu);
    }

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TbMenu tbMenu) {
        return this.tbMenuMapper.update(tbMenu);
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
