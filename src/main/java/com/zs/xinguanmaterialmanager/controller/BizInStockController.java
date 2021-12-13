package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizInStock;
import com.zs.xinguanmaterialmanager.entity.BizProduct;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.service.BizProductService;
import com.zs.xinguanmaterialmanager.service.BizSupplierService;
import com.zs.xinguanmaterialmanager.service.impl.BizInStockServiceImpl;
import com.zs.xinguanmaterialmanager.util.R;
import com.zs.xinguanmaterialmanager.vo.InStockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
//fan
/**
 * (BizOutStock)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:28
 */
@RestController
@RequestMapping("/XinGuan/inStock")
public class BizInStockController {
    @Autowired
    private BizInStockServiceImpl inStockService;
    @Resource
    private BizSupplierService bizSupplierService;
    @Resource
    private BizProductService bizProductService;

    /**
     * 物资入库
     */
    @PostMapping("/addIntoStock")
    public R addIntoStock(@RequestBody InStockVO inStockVO) {
        BizSupplier bizSupplier = new BizSupplier(
                inStockVO.getId(),
                inStockVO.getSupplierName(),
                inStockVO.getAddress(),
                inStockVO.getEmail(),
                inStockVO.getPhone(),
                inStockVO.getCreateTime(),
                inStockVO.getSort(),
                inStockVO.getContact()
        );
        bizSupplierService.insert(bizSupplier);

//        for (BizProduct bizProduct : inStockVO.getProduct()) {
//            bizProductService.insert(bizProduct);
//        }

        BizInStock bizInStock=new BizInStock();
        bizInStock.setType(inStockVO.getType());
        bizInStock.setInNum(inStockVO.getInNum());
        bizInStock.setOperator(inStockVO.getOperator());
        bizInStock.setStatus(inStockVO.getStatus());
        bizInStock.setProductNumber(inStockVO.getProductNumber());
        bizInStock.setRemark(inStockVO.getRemark());
        bizInStock.setSupplierId(inStockVO.getSupplierId());
        bizInStock.setCreateTime(inStockVO.getCreateTime());
        bizInStock.setModified(inStockVO.getModifiedTime());
        inStockService.insert(bizInStock);

        return R.ok().setData(1);
    }

    /**
     * 在回收站中恢复入库单
     *
     * @param bizInStock
     * @return
     */
    @PutMapping("/back")
    public R back(BizInStock bizInStock) {

        return R.ok().setData(inStockService.update(bizInStock));
    }
    /**
     * 移入回收站
     */
    @PutMapping("/remove/{id}")
    public R remove(@PathVariable("id") long id) {
        Integer remove = inStockService.remove(id);
        return R.ok().setData(remove);
    }


    /**
     * 查询明细
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") long id,int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BizProduct> bizProductPageInfo = inStockService.detail2(id, pageNum, pageSize);
        BizSupplier bizSupplier = inStockService.detail1(id);
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(bizSupplier);
        objects.add(bizProductPageInfo);
        PageInfo pageInfo = new PageInfo(objects);
        return R.ok().setData(pageInfo);
    }


//    /**
//     * 查询明细头
//     */
//    @RequestMapping("/detail1")
//    public R detail(int id) {
//        return R.ok().setData(inStockService.detail1(id));
//    }
//
//    /**
//     * 查询明细表分页
//     *
//     * @param id
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @RequestMapping("/detail2")
//    public R detail2(int id, int pageNum, int pageSize) {
//        return R.ok().setData(inStockService.detail2(id, pageNum, pageSize));
//    }

    /**
     * 删除
     *
     * @param inNum
     * @return
     */
    @RequestMapping("/delete")
    public R delete(String inNum) {
        inStockService.delete(inNum);
        return R.ok();
    }

    @RequestMapping("/findInStockList")
    public R findInStockList(InStockVO inStockVO, int pageNum, int pageSize) {
        PageInfo<InStockVO> inStockList = inStockService.findInStockList(inStockVO, pageNum, pageSize);
        return R.ok().setData(inStockList);
    }

    @RequestMapping("/publish")
    public R publish(BizInStock bizInStock) {
        return R.ok().setData(inStockService.publish(bizInStock));
    }
//fan
}
