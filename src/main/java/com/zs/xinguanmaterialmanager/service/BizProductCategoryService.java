package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizProductCategory;

import java.util.List;
import java.util.Map;

/**
 * (BizProductCategory)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:32
 */
public interface BizProductCategoryService {
//fan
    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    BizProductCategory queryById(Long id);

    /**
     * 查询所有父级
     * @return
     */
    PageInfo<BizProductCategory> findAll(int pageNum,int pageSize);
    List<BizProductCategory> findAll();

    /**
     * 查询所有子级
     * @param
     * @return
     */
    PageInfo<BizProductCategory> findAllByPid(Map<String,Object> map);
    /**
     * 新增数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    int insert(BizProductCategory bizProductCategory);




    PageInfo<BizProductCategory> list(int pageNum,int pageSize);
    /**
     * 修改数据
     *
     * @param bizProductCategory 实例对象
     * @return 实例对象
     */
    int update(BizProductCategory bizProductCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Long id);

    /**
     *  获取pid=父级id 的 子级id
     * @param id
     * @return
     */
    List<BizProductCategory> findById(long id);

    /**
     * 父类树
     * @return
     */
    PageInfo<BizProductCategory> findById1(int pageNum,int pageSize);

    List<BizProductCategory> listWithTree();
    //fan
    List<BizProductCategory>  getChildrens(BizProductCategory root,List<BizProductCategory> all);
}
