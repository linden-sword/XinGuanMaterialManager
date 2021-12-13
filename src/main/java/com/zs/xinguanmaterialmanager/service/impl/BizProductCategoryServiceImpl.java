package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizProductCategory;
import com.zs.xinguanmaterialmanager.mapper.BizProductCategoryMapper;
import com.zs.xinguanmaterialmanager.service.BizProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (BizProductCategory)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:32
 */
@Service("bizProductCategoryService")
public class BizProductCategoryServiceImpl implements BizProductCategoryService {
    //fan
    @Resource
    private BizProductCategoryMapper bizProductCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizProductCategory queryById(Long id) {
        return this.bizProductCategoryMapper.queryById(id);
    }

    /**
     * 查询所有父级
     *
     * @return
     */
    @Override
    public PageInfo<BizProductCategory> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<BizProductCategory> bizProductCategoryMapperAll = bizProductCategoryMapper.findAll(pageNum, pageSize);

        PageInfo<BizProductCategory> pageInfo = new PageInfo<>(bizProductCategoryMapperAll);
        return pageInfo;
    }

    @Override
    public List<BizProductCategory> findAll() {
        return null;
    }

    /**
     * 查询所有子级
     *
     * @param
     * @return
     */
    @Override
    public PageInfo<BizProductCategory> findAllByPid(Map<String, Object> map) {
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");

        PageHelper.startPage(pageNum, pageSize);
        long pid = (long) map.get("pid");
        List<BizProductCategory> byPid = bizProductCategoryMapper.findAllByPid(pid);
        for (BizProductCategory bbb : byPid) {
            List<BizProductCategory> byPid1 = bizProductCategoryMapper.findAllByPid(bbb.getId());
            bbb.setChildren(byPid1);
        }
        PageInfo<BizProductCategory> pageInfo = new PageInfo<>(byPid);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(BizProductCategory bizProductCategory) {
        return bizProductCategoryMapper.insert(bizProductCategory);

    }

    @Override
    public PageInfo<BizProductCategory> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<BizProductCategory> bizProductCategoryMapperAll = bizProductCategoryMapper.list(pageNum, pageSize);

        PageInfo<BizProductCategory> pageInfo = new PageInfo<>(bizProductCategoryMapperAll);
        return pageInfo;
    }

    /**
     * 修改数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    @Override
    public int update(BizProductCategory bizProductCategory) {
        return bizProductCategoryMapper.update(bizProductCategory);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Long id) {
        return bizProductCategoryMapper.deleteById(id);
    }

    @Override
    public List<BizProductCategory> findById(long id) {
        return bizProductCategoryMapper.findById(id);
    }

    @Override
    public PageInfo<BizProductCategory> findById1(int pageNum, int pageSize) {
        return null;
    }


    /**
     * 父类树
     */

    public List<BizProductCategory> findById1() {

        return bizProductCategoryMapper.findAll1();
    }

    @Override
    public PageInfo listWithTree(int pageNum, int pageSize) {
        List<BizProductCategory> biz = bizProductCategoryMapper.listWithTree();
        List<BizProductCategory> collect = biz.stream().filter(bizProductCategory ->
                bizProductCategory.getPid() == 0
        ).map((menu) -> {
            menu.setChildren(getChildrens(menu, biz));
            return menu;
        }).collect(Collectors.toList());
        //设置分页规则
        System.out.println("////==== pageNum & pageSize: "+pageNum+" , "+pageSize);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BizProductCategory> pageInfo = new PageInfo<>(collect);
        return pageInfo;
    }

    //递归查找所有菜单的子菜单
    @Override
    public List<BizProductCategory> getChildrens(BizProductCategory root, List<BizProductCategory> all) {
        List<BizProductCategory> childern = all.stream().filter(bizProductCategory -> {
            return bizProductCategory.getPid() == root.getId();
        }).map(bizProductCategory -> {
            bizProductCategory.setChildren(getChildrens(bizProductCategory, all));
            return bizProductCategory;
        }).collect(Collectors.toList());
        return childern;
    }

}
