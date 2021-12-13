package com.zs.xinguanmaterialmanager.controller;

import com.zs.xinguanmaterialmanager.entity.BizOutStock;
import com.zs.xinguanmaterialmanager.entity.DetailOutStock;
import com.zs.xinguanmaterialmanager.entity.outStockVO;
import com.zs.xinguanmaterialmanager.service.BizOutStockService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (BizOutStock)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:28
 */
@RestController
@RequestMapping("/XinGuan/outStock")
public class BizOutStockController {

    @Autowired
    private BizOutStockService bizOutStockService;

    /**
     * @Author yym
     * @Description //TODO 提交发放单
     * @Date 2021/12/8 21:33
     * @Param [outStockVO]
     */
    @PostMapping("/addOutStock")
    public R addOutStock(@RequestBody outStockVO outStockVO) {

        return R.ok().setData(bizOutStockService.addOutStock(outStockVO));
    }

    /**
     * @Author yym
     * @Description //TODO 从回收站恢复数据
     * @Date 2021/12/9 9:27
     * @Param [id]
     */
    @PutMapping("/back/{id}")
    public R backOutStock(@PathVariable Long id) {

        return R.ok().setData(bizOutStockService.backOutStock(id));
    }

    /**
     * @Author yym
     * @Description //TODO 通过ID删除物资发放单
     * @Date 2021/12/9 9:57
     * @Param [id]
     */
    @DeleteMapping("/delete/{id}")
    public R deleteOutStock(@PathVariable Long id) {

        return R.ok().setData(bizOutStockService.deleteOutStock(id));
    }

    /**
     * @Author yym
     * @Description //TODO 发放单明细
     * @Date 2021/12/9 10:46
     * @Param [id]
     */
    @GetMapping("/detail/{id}")
    public R detailOutStock(@PathVariable Long id,
                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        DetailOutStock detail = bizOutStockService.detailOutStock(id, pageNum, 10);
        return R.ok().setData(detail);
    }

    /**
     * @Author yym
     * @Description //TODO  查询出单列表
     * @Date 2021/12/9 10:55
     * @Param [pageNum, pageSize, bizOutStock]
     */
    @GetMapping("/findOutStockList")
    public R findOutStockList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize") Integer pageSize,
                              BizOutStock bizOutStock) {

        return R.ok().setData(bizOutStockService.findOutStockList(pageNum, pageSize, bizOutStock));
    }

    /**
     * @Author yym
     * @Description //TODO 审核出库单
     * @Date 2021/12/9 12:15
     * @Param [id]
     */
    @PutMapping("/publish/{id}")
    public R auditOutStock(@PathVariable Long id) {
        return R.ok().setData(bizOutStockService.auditOutStock(id));
    }

    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/9 14:36
     * @Param [id]
     */
    @PutMapping("/remove/{id}")
    public R removeOutStock(@PathVariable Long id) {

        return R.ok().setData(bizOutStockService.removeOutStock(id));
    }

}
