package com.zs.xinguanmaterialmanager.controller;

import com.zs.xinguanmaterialmanager.entity.BizProduct;
import com.zs.xinguanmaterialmanager.service.BizProductService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (BizProduct)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:31
 */
@RestController
@RequestMapping("/XinGuan/product")
public class BizProductController {
    @Autowired
    private BizProductService bizProductService;

    /**
     * @Author yym
     * @Description //TODO 添加物资数据
     * @Date 2021/12/7 16:10
     * @Param [bizProduct]
     */
    @PostMapping("/add")
    public R addProuduct(@RequestBody BizProduct bizProduct) throws Exception {
        return R.ok().setData(bizProductService.addProuduct(bizProduct));
    }

    /**
     * @Author yym
     * @Description //TODO 从回收站回复物资
     * @Date 2021/12/7 16:15
     * @Param [id]
     */
    @PutMapping("/back/{id}")
    public R backProuduct(@PathVariable Long id) {
        return R.ok().setData(bizProductService.backProuduct(id));
    }

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资
     * @Date 2021/12/7 16:26
     * @Param [id]
     */
    @DeleteMapping("/delete/{id}")
    public R deleteProuductById(@PathVariable Long id) {
        return R.ok().setData(bizProductService.deleteProuductById(id));
    }

    /**
     * @Author yym
     * @Description //TODO 跟ID查询一条物资数据（编辑回显）
     * @Date 2021/12/7 16:35
     * @Param [id]
     */
    @GetMapping("/edit/{id}")
    public R editProuductById(@PathVariable Long id) {
        return R.ok().setData(bizProductService.editProuductById(id));
    }

    /**
     * @Author yym
     * @Description //TODO 分页查询物资所有库存信息,饼图使用
     * @Date 2021/12/7 19:18
     * @Param [pageNum, pageSize]
     */
    @GetMapping("/findAllStocks")
    public R findAllStocks(Integer pageNum, Integer pageSize) {
        return R.ok().setData(bizProductService.findAllStocks(pageNum, pageSize));
    }

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询
     * @Date 2021/12/7 19:50
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    @GetMapping("/findProductList")
    public R findProductList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize") Integer pageSize,
                             @RequestParam(value = "categorys", required = false) String categorys,
                             BizProduct bizProduct) {
        buildCategorySearch(categorys, bizProduct);
        return R.ok().setData(bizProductService.findProductList(pageNum, pageSize, bizProduct));
    }

    /**
     * @Author yym
     * @Description //TODO 物资列表,根据物资名模糊查询(物资库存)
     * @Date 2021/12/7 20:21
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    @GetMapping("/findProductStocks")
    public R findProductStocks(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "categorys", required = false) String categorys,
                               BizProduct bizProduct) {
        buildCategorySearch(categorys, bizProduct);
        return R.ok().setData(bizProductService.findProductStocks(pageNum, pageSize, bizProduct));
    }

    /**
     * @Author yym
     * @Description //TODO 根据物资名模糊查询(可入库物资列表)
     * @Date 2021/12/7 21:10
     * @Param [pageNum, pageSize, categorys, bizProduct]
     */
    @GetMapping("/findProducts")
    public R findProducts(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize") Integer pageSize,
                          @RequestParam(value = "categorys", required = false) String categorys,
                          BizProduct bizProduct) {
        buildCategorySearch(categorys, bizProduct);
        return R.ok().setData(bizProductService.findProducts(pageNum, pageSize, bizProduct));
    }

    /**
     * @Author yym
     * @Description //TODO 添加物资审核
     * @Date 2021/12/8 10:16
     * @Param [id]
     */
    @PutMapping("/publish/{id}")
    public R auditProducts(@PathVariable Long id) {
        return R.ok().setData(bizProductService.auditProducts(id));
    }


    /**
     * @Author yym
     * @Description //TODO 移入回收站
     * @Date 2021/12/8 10:35
     * @Param [id]
     */
    @PutMapping("/remove/{id}")
    public R removeProducts(@PathVariable Long id) {
        return R.ok().setData(bizProductService.removeProducts(id));
    }

    /**
     * @Author yym
     * @Description //TODO 更新物资信息
     * @Date 2021/12/8 11:11
     * @Param [id, bizProduct]
     */
    @PutMapping("/update/{id}")
    public R updateProducts(@PathVariable Long id, @RequestBody BizProduct bizProduct) {
        return R.ok().setData(bizProductService.updateProducts(id, bizProduct));
    }

    /**
     * @Author yym
     * @Description //TODO 封装物资查询条件
     * @Date 2021/12/7 19:41
     * @Param [categorys, bizProduct]
     */
    private void buildCategorySearch(@RequestParam(value = "categorys", required = false) String categorys, BizProduct bizProduct) {
        if (categorys != null && !"".equals(categorys)) {
            String[] split = categorys.split(",");
            switch (split.length) {
                case 1:
                    bizProduct.setOneCategoryId(Long.parseLong(split[0]));
                    break;
                case 2:
                    bizProduct.setOneCategoryId(Long.parseLong(split[0]));
                    bizProduct.setTwoCategoryId(Long.parseLong(split[1]));
                    break;
                case 3:
                    bizProduct.setOneCategoryId(Long.parseLong(split[0]));
                    bizProduct.setTwoCategoryId(Long.parseLong(split[1]));
                    bizProduct.setThreeCategoryId(Long.parseLong(split[2]));
                    break;
            }
        }
    }
}
