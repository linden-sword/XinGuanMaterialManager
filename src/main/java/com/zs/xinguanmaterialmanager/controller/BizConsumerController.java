package com.zs.xinguanmaterialmanager.controller;

import com.zs.xinguanmaterialmanager.entity.BizConsumer;
import com.zs.xinguanmaterialmanager.service.BizConsumerService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (BizConsumer)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:23
 */
@RestController
@RequestMapping("/XinGuan/consumer")
public class BizConsumerController {
    @Autowired
    private BizConsumerService consumerService;

    /**
     * @Author yym
     * @Description //TODO 新增物资去向
     * @Date 2021/12/6 22:02
     * @Param [bizConsumer]
     */
    @PostMapping("/add")
    public R addConsumer(@RequestBody BizConsumer bizConsumer) {

        return R.ok().setData(consumerService.addConsumer(bizConsumer));
    }

    /**
     * @Author yym
     * @Description //TODO 根据ID删除物资去向
     * @Date 2021/12/6 22:17
     * @Param [id]
     */
   /* @ControllerEndpoint(exceptionMessage = "物资去向删除失败", operation = "物资去向删除")
    @RequiresPermissions({"consumer:delete"})
    @ApiOperation(value = "删除去向", notes = "删除去向信息")*/
    @DeleteMapping("/delete/{id}")
    public R deleteConsumer(@PathVariable Long id) {

        return R.ok().setData(consumerService.deleteConsumer(id));
    }

    /**
     * @Author yym
     * @Description //TODO 根据ID查询单条物资去向信息
     * @Date 2021/12/7 9:16
     * @Param [id]
     */
    @GetMapping("/edit/{id}")
    public R findById(@PathVariable Long id) {
        return R.ok().setData(consumerService.findById(id));
    }

    /**
     * @Author yym
     * @Description //TODO 分页查询所有物资去向信息
     * @Date 2021/12/7 9:16
     * @Param []
     */
    @GetMapping("/findAll")
    public R findAllConsumer(int pageNum, int pageSize) {
        return R.ok().setData(consumerService.findAllPageInfoConsumer(pageNum, pageSize));
    }

    /**
     * @Author yym
     * @Description //TODO 根据条件模糊查询物资去处信息
     * @Date 2021/12/7 11:52
     * @Param [pageNum, pageSize, bizConsumer]
     */
    @GetMapping("/findConsumerList")
    public R findConsumerList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize") Integer pageSize,
                              BizConsumer bizConsumer) {
        return R.ok().setData(consumerService.findConsumerList(pageNum, pageSize, bizConsumer));
    }

    /**
     * @Author yym
     * @Description //TODO 根据ID更新物资去处信息
     * @Date 2021/12/7 11:52
     * @Param [id, bizConsumer]
     */
    @PutMapping("/update/{id}")
    public R updateConsumer(@PathVariable Long id, @RequestBody BizConsumer bizConsumer) {

        return R.ok().setData(consumerService.updateConsumer(id, bizConsumer));
    }
}
