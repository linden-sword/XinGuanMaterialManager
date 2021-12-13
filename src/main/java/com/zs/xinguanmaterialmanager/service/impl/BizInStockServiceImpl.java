package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizInStock;
import com.zs.xinguanmaterialmanager.entity.BizInStockInfo;
import com.zs.xinguanmaterialmanager.entity.BizProduct;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.mapper.BizInStockInfoMapper;
import com.zs.xinguanmaterialmanager.mapper.BizInStockMapper;
import com.zs.xinguanmaterialmanager.mapper.BizProductMapper;
import com.zs.xinguanmaterialmanager.mapper.BizSupplierMapper;
import com.zs.xinguanmaterialmanager.service.BizInStockService;
import com.zs.xinguanmaterialmanager.vo.InStockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (BizInStock)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:25
 */
@Service("bizInStockService")
public class BizInStockServiceImpl implements BizInStockService {
    @Resource
//fan
    private BizInStockMapper bizInStockMapper;
    @Autowired
    private BizSupplierMapper supplierMapper;
    @Autowired
    private BizProductMapper productMapper;
    @Autowired
    private BizInStockInfoMapper inStockInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizInStock queryById(int id) {
        return this.bizInStockMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizInStock insert(BizInStock bizInStock) {
        this.bizInStockMapper.insert(bizInStock);
        return bizInStock;
    }

    /**
     * 修改数据
     * 从回收站中恢复数据
     *
     * @param bizInStock 实例对象
     * @return 实例对象
     */
    @Override
    public int update(BizInStock bizInStock) {
        bizInStock.setStatus(0);
        return bizInStockMapper.update(bizInStock);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.bizInStockMapper.deleteById(id) > 0;
    }

    /**
     * 移入回收站
     *
     * @param id
     * @return
     */
    @Override
    public Integer remove(long id) {
        BizInStock bizInStock = bizInStockMapper.queryById(id);
        bizInStock.setStatus(1);
        return bizInStockMapper.update(bizInStock);
    }


    /**
     * 查询明细
     */
    public PageInfo<BizProduct> detail2(long id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BizInStock inStock = bizInStockMapper.queryById(id);

        List<BizInStockInfo> byInNum = inStockInfoMapper.findByInNum(inStock.getInNum());
        List<BizProduct> bizProducts =new ArrayList<>();
        for (BizInStockInfo bizInStockInfo : byInNum){
            BizProduct bizProduct = productMapper.queryBypNum(bizInStockInfo.getPNum());
            bizProducts.add(bizProduct);
        }

        PageInfo<BizProduct> pageInfo = new PageInfo<>(bizProducts);
        return pageInfo;
    }

    /**
     * 查询明细头
     */
    @Override
    public BizSupplier detail1(long id) {
        BizInStock bizInStock = bizInStockMapper.queryById(id);
        BizSupplier bizSupplier = supplierMapper.queryById(bizInStock.getSupplierId());
        return bizSupplier;
    }

    /**
     * 通过inNum删除入库表信息
     *
     * @param inNum
     * @return
     */
    @Override
    @Transactional
    public Integer delete(String inNum) {

        bizInStockMapper.deleteInStock(inNum);
        inStockInfoMapper.deleteInfo(inNum);

        return 1;
    }

    /**
     * 多条件模糊查询入库信息分页
     *
     * @param inStockVO
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<InStockVO> findInStockList(InStockVO inStockVO, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InStockVO> inStockList = bizInStockMapper.findInStockList(inStockVO);
        PageInfo<InStockVO> pageInfo = new PageInfo<>(inStockList);
        return pageInfo;
    }

    /**
     * 入库审核
     *
     * @param bizInStock
     * @return
     */
    @Override
    public Integer publish(BizInStock bizInStock) {
        bizInStock.setStatus(2);
        return bizInStockMapper.update(bizInStock);
    }

    //fan
}
