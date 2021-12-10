package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizProduct;
import com.zs.xinguanmaterialmanager.entity.BizProductStock;
import com.zs.xinguanmaterialmanager.mapper.BizProductMapper;
import com.zs.xinguanmaterialmanager.mapper.BizProductStockMapper;
import com.zs.xinguanmaterialmanager.service.BizProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (BizProduct)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:31
 */
@Service("bizProductService")
@Transactional
public class BizProductServiceImpl implements BizProductService {
    @Resource
    private BizProductMapper bizProductMapper;

    @Autowired
    private BizProductStockMapper bizProductStockMapper;

    /**
     * @Author yym
     * @Description //TODO 跟ID查询一条物资数据（编辑回显）
     * @Date 2021/12/7 16:35
     * @Param [id]
     */
    @Override
    public BizProduct editProuductById(Long id) {
        return this.bizProductMapper.editProuductById(id);
    }

    /**
     * @Author yym
     * @Description //TODO 添加物资数据
     * @Date 2021/12/7 16:10
     * @Param [bizProduct]
     */
    @Override
    public boolean addProuduct(BizProduct bizProduct) throws Exception {
        if (bizProduct.getCategoryKeys().size() == 3) {

            String s = UUID.randomUUID().toString().substring(0, 16);
            bizProduct.setPNum(s);
            List<Long> keys = bizProduct.getCategoryKeys();
            bizProduct.setOneCategoryId(keys.get(0));
            bizProduct.setTwoCategoryId(keys.get(1));
            bizProduct.setThreeCategoryId(keys.get(2));
            bizProduct.setCreateTime(new Date());
            bizProduct.setModifiedTime(new Date());
            return this.bizProductMapper.addProuduct(bizProduct) > 0;
        } else {
            throw new RuntimeException("必须要三级分级");
        }
    }

    /**
     * 修改数据
     *
     * @param bizProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BizProduct update(BizProduct bizProduct) {
        this.bizProductMapper.update(bizProduct);
        return this.editProuductById(bizProduct.getId());
    }

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资
     * @Date 2021/12/7 16:26
     * @Param [id]
     */
    @Override
    public boolean deleteProuductById(Long id) {
        BizProduct bizProduct = bizProductMapper.editProuductById(id);
        int i = this.bizProductMapper.deleteProuductById(id);
        if (i > 0) {
            BizProductStock stockMapper = new BizProductStock();
            stockMapper.setPNum(bizProduct.getPNum());
            bizProductStockMapper.deleteBypNum(stockMapper.getPNum());
        }
        return i > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 从回收站回复物资
     * @Date 2021/12/7 16:15
     * @Param [id]
     */
    @Override
    public boolean backProuduct(Long id) {
        return bizProductMapper.backProuduct(id) > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 物资所有库存信息,饼图使用
     * @Date 2021/12/7 17:29
     * @Param [pageNum, pageSize]
     */
    @Override
    public List<BizProduct> findAllStocks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizProduct> allStocks = bizProductMapper.findAllStocks();
        return allStocks;
    }

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询
     * @Date 2021/12/7 19:50
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    @Override
    public PageInfo<BizProduct> findProductList(Integer pageNum, Integer pageSize, BizProduct bizProduct) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizProduct> productList = bizProductMapper.findProductList(bizProduct);
        PageInfo<BizProduct> pageInfo = new PageInfo<BizProduct>(productList);
        return pageInfo;
    }

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询(物资库存)
     * @Date 2021/12/7 20:21
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    @Override
    public PageInfo<BizProduct> findProductStocks(Integer pageNum, Integer pageSize, BizProduct bizProduct) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizProduct> productList = bizProductMapper.findProductStocks(bizProduct);
        PageInfo<BizProduct> pageInfo = new PageInfo<BizProduct>(productList);
        return pageInfo;
    }

    /**
     * @Author yym
     * @Description //TODO 根据物资名模糊查询(可入库物资列表)
     * @Date 2021/12/7 21:10
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    @Override
    public PageInfo<BizProduct> findProducts(Integer pageNum, Integer pageSize, BizProduct bizProduct) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizProduct> productList = bizProductMapper.findProducts(bizProduct);
        PageInfo<BizProduct> pageInfo = new PageInfo<BizProduct>(productList);
        return pageInfo;
    }

    /**
     * @Author yym
     * @Description //TODO 添加物资审核
     * @Date 2021/12/8 10:16
     * @Param [id]
     */
    @Override
    public boolean auditProducts(Long id) {
        int i = bizProductMapper.auditProducts(id);
        //审核成功向库存中添加数据
        if (i > 0) {
            BizProductStock stockMapper = new BizProductStock();
            BizProduct bizProduct = bizProductMapper.editProuductById(id);
            stockMapper.setPNum(bizProduct.getPNum());
            stockMapper.setStock(0L);
            bizProductStockMapper.insert(stockMapper);
        }
        return i > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/8 10:35
     * @Param [id]
     */
    @Override
    public boolean removeProducts(Long id) {
        return bizProductMapper.removeProducts(id) > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 更新物资信息
     * @Date 2021/12/8 11:11
     * @Param [id, bizProduct]
     */
    @Override
    public boolean updateProducts(Long id, BizProduct bizProduct) {
        if (bizProduct.getCategoryKeys().size() == 3) {
            bizProduct.setId(id);
            List<Long> keys = bizProduct.getCategoryKeys();
            bizProduct.setOneCategoryId(keys.get(0));
            bizProduct.setTwoCategoryId(keys.get(1));
            bizProduct.setThreeCategoryId(keys.get(2));
            bizProduct.setModifiedTime(new Date());
            return this.bizProductMapper.updateProducts(bizProduct) > 0;
        } else {
            throw new RuntimeException("必须要三级分级");
        }
    }
}
