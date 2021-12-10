package com.zs.xinguanmaterialmanager.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.mapper.BizSupplierMapper;
import com.zs.xinguanmaterialmanager.service.BizSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (BizSupplier)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:35
 */
@Service("bizSupplierService")
public class BizSupplierServiceImpl implements BizSupplierService {
    @Autowired
    private BizSupplierMapper bizSupplierMapper;
//fan
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizSupplier queryById(Long id) {
        return bizSupplierMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizSupplier 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(BizSupplier bizSupplier) {
       return bizSupplierMapper.insert(bizSupplier);
    }

    /**
     * 修改数据
     *
     * @param bizSupplier 实例对象
     * @return 实例对象
     */
    @Override
    public int update(BizSupplier bizSupplier) {
        return bizSupplierMapper.update(bizSupplier);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Long id) {
        return bizSupplierMapper.deleteById(id);
    }


    /**
     * 所有来源
     * @return
     */
    @Override
    public PageInfo<BizSupplier> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<BizSupplier> bizSuppliers=  bizSupplierMapper.findAll();

        PageInfo<BizSupplier> pageInfo=new PageInfo<>(bizSuppliers);

        return pageInfo;
    }

    /**
     * 根据来源名模糊查询
     * @param
     * @return
     */
    @Override
    public PageInfo<BizSupplier> findSupplierList(Map<String,Object> map,BizSupplier bizSupplier) {
        int pageNum=(int) map.get("pageNum");
        int pageSize=(int) map.get("pageSize");

        PageHelper.startPage(pageNum,pageSize);

        List<BizSupplier> bizSupplierList=bizSupplierMapper.findSupplierList(bizSupplier);

        PageInfo<BizSupplier> pageInfo=new PageInfo<>(bizSupplierList);

        return pageInfo;
    }
    //fan
}
