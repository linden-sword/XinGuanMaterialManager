package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.*;
import com.zs.xinguanmaterialmanager.mapper.*;
import com.zs.xinguanmaterialmanager.service.BizOutStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (BizOutStock)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:28
 */
@Service("bizOutStockService")
@Transactional
public class BizOutStockServiceImpl implements BizOutStockService {
    @Resource
    private BizOutStockMapper bizOutStockMapper;

    @Autowired
    private BizProductMapper bizProductMapper;

    @Autowired
    private BizProductStockMapper bizProductStockMapper;

    @Autowired
    private BizOutStockInfoMapper bizOutStockInfoMapper;

    @Autowired
    private BizConsumerMapper bizConsumerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BizOutStock queryById(Long id) {
        return this.bizOutStockMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizOutStock insert(BizOutStock bizOutStock) {
        this.bizOutStockMapper.addOutStock(bizOutStock);
        return bizOutStock;
    }

    /**
     * 修改数据
     *
     * @param bizOutStock 实例对象
     * @return 实例对象
     */
    @Override
    public BizOutStock update(BizOutStock bizOutStock) {
        this.bizOutStockMapper.update(bizOutStock);
        return this.queryById(bizOutStock.getId());
    }

    /**
     * @Author yym
     * @Description //TODO 通过ID删除物资发放单
     * @Date 2021/12/9 9:57
     * @Param [id]
     */
    @Override
    public boolean deleteOutStock(Long id) {
        //根据ID查询out_num,product_number
        BizOutStock bizOutStock = bizOutStockMapper.queryById(id);
        //根据out_num查询出p_num
        List<BizOutStockInfo> bizOutStockInfo = bizOutStockInfoMapper.queryByOutNum(bizOutStock.getOutNum());
        //如果是审核时删除增加库存，删除关系表
        if (bizOutStock.getStatus() == 2) {
            for (BizOutStockInfo outStockInfo : bizOutStockInfo) {
                //根据Id删除biz_out_stock_info表中数据
                bizOutStockInfoMapper.deleteById(outStockInfo.getId());
                //根据p_num查询库存
                BizProductStock bizProductStock = bizProductStockMapper.queryBypNum(outStockInfo.getPNum());
                //增加库存
                bizProductStock.setStock(bizProductStock.getStock() + outStockInfo.getProductNumber());
                bizProductStockMapper.update(bizProductStock);
            }
        }
        //删除入库单
        return this.bizOutStockMapper.deleteOutStock(id) > 0;
    }


    /**
     * @Author yym
     * @Description //TODO 出库提交发放单
     * @Date 2021/12/8 21:02
     * @Param [outStockVO]
     */
    @Override
    public boolean addOutStock(outStockVO outStockVO) {
        int number = 0;
        BizOutStock bizOutStock = new BizOutStock();
        if (outStockVO.getConsumerId() == null || outStockVO.getConsumerId().equals("")) {
            //新增去向
            BizConsumer consumer = new BizConsumer(outStockVO.getName(),
                    outStockVO.getAddress(),
                    new Date(),
                    new Date(),
                    outStockVO.getPhone(),
                    outStockVO.getSort(),
                    outStockVO.getContact());
            //添加新增的出库信息
            bizConsumerMapper.addConsumer(consumer);
            //把自动生成成的ID设置给outStockVO
            outStockVO.setConsumerId(consumer.getId());

            return extracted(outStockVO, number, bizOutStock);
        }
        //已知去向
        return extracted(outStockVO, number, bizOutStock);
    }

    /**
     * @Author yym
     * @Description //TODO 从回收站恢复数据
     * @Date 2021/12/9 9:27
     * @Param [id]
     */
    @Override
    public boolean backOutStock(Long id) {

        return bizOutStockMapper.backOutStock(id) > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 查询出单列表
     * @Date 2021/12/9 10:56
     * @Param [pageNum, pageSize, bizOutStock]
     */
    @Override
    public PageInfo<BizOutStock> findOutStockList(Integer pageNum, Integer pageSize, BizOutStock bizOutStock) {
        PageHelper.startPage(pageNum, pageSize);
        List<BizOutStock> outStockList = bizOutStockMapper.findOutStockList(bizOutStock);
        PageInfo<BizOutStock> pageInfo = new PageInfo<BizOutStock>(outStockList);
        return pageInfo;
    }

    /**
     * @Author yym
     * @Description //TODO 审核出库单
     * @Date 2021/12/9 12:15
     * @Param [id]
     */
    @Override
    public boolean auditOutStock(Long id) {
        return bizOutStockMapper.auditOutStock(id) > 0;
    }

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/9 14:36
     * @Param [id]
     */
    @Override
    public boolean removeOutStock(Long id) {

        return bizOutStockMapper.removeOutStock(id) > 0;
    }


    /**
     * @Author yym
     * @Description //TODO 发放单明细
     * @Date 2021/12/9 15:36
     * @Param [id, pageNum, pageSize]
     */
    @Override
    public DetailOutStock detailOutStock(Long id, Integer pageNum, Integer pageSize) {
        //初始化返回值
        DetailOutStock detailOutStock = new DetailOutStock();
        //根据ID查询consumer_id
        BizOutStock bizOutStock = bizOutStockMapper.queryById(id);
        //设置detailOutStock所需要的数据
        detailOutStock.setOperator(bizOutStock.getOperator());
        detailOutStock.setOutNum(bizOutStock.getOutNum());
        detailOutStock.setStatus(bizOutStock.getStatus());
        detailOutStock.setType(bizOutStock.getType());
        //根据consumer_id查询consumer
        BizConsumer consumer = bizConsumerMapper.findById(bizOutStock.getConsumerId());
        detailOutStock.setConsumerVO(consumer);

        //分页
        PageHelper.startPage(pageNum, pageSize);
        //根据out_num查询出itemVOS数据
        List<BizProduct> productList = bizProductMapper.detailOutStock(bizOutStock);
        PageInfo<BizProduct> pageInfo = new PageInfo<BizProduct>(productList);
        //设置样式发放的数量
        detailOutStock.setTotal(pageInfo.getTotal());
        detailOutStock.setItemVOS(productList);
        //返回发放单
        return detailOutStock;
    }

    /**
     * @Author yym
     * @Description //TODO 处理出库信息
     * @Date 2021/12/8 21:01
     * @Param [outStockVO, number, bizOutStock]
     */
    private boolean extracted(outStockVO outStockVO, int number, BizOutStock bizOutStock) {
        for (Products product : outStockVO.getProducts()) {
            bizOutStock = new BizOutStock(outStockVO.getId(),
                    UUID.randomUUID().toString().substring(0, 16),
                    outStockVO.getType(),
                    outStockVO.getOperator(),
                    new Date(),
                    product.getProductNumber(),
                    outStockVO.getConsumerId(),
                    outStockVO.getRemark(),
                    outStockVO.getStatus(),
                    outStockVO.getPriority());
            number += product.getProductNumber();
            //查询库存
            //通过productID查询出pNum
            BizProduct bizProduct = bizProductMapper.editProuductById(product.getProductId());
            //通过pNum查询物资总数
            BizProductStock bizProductStock = bizProductStockMapper.queryBypNum(bizProduct.getPNum());
            if (bizProductStock.getStock() >= product.getProductNumber()) {
                //向biz_out_stock_info中添加信息
                //设置数据
                BizOutStockInfo bizOutStockInfo = new BizOutStockInfo(bizOutStock.getOutNum(),
                        bizProduct.getPNum(), product.getProductNumber(), new Date(), new Date());
                //插入
                int insert = bizOutStockInfoMapper.insert(bizOutStockInfo);
                //从库存减去出库数量
                long stock = bizProductStock.getStock() - product.getProductNumber();
                bizProductStock.setStock(stock);
                bizProductStockMapper.update(bizProductStock);
            } else {
                return false;
            }
        }
        //向biz_out_stock表插入数据
        bizOutStock.setProductNumber(number);
        bizOutStock.setStatus(2);
        int i = bizOutStockMapper.addOutStock(bizOutStock);
        return i > 0;
    }
}
