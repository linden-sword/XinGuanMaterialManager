package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizHealth;
import com.zs.xinguanmaterialmanager.service.BizHealthService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (BizHealth)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:24
 */
@RestController
@RequestMapping("/XinGuan/bizHealth")
public class BizHealthController {
    @Resource
    private BizHealthService bizHealthService;

    /**
     * 用户健康上报历史记录
     */
    @GetMapping
    public R getHistory(Integer pageNum, Integer pageSize) {
        PageInfo<BizHealth> allBizHealthByPage = bizHealthService.findAllBizHealthByPage(pageNum, pageSize);
        if (!allBizHealthByPage.getList().isEmpty()) {
            return R.ok().setData(allBizHealthByPage);
        }
        return R.fail();
    }

    /**
     * 用户健康上报
     */
    @PostMapping
    public R report(@RequestBody BizHealth bizHealth) {
        return R.ok().setData(this.bizHealthService.insert(bizHealth));
    }

    /**
     * 判断今日是否已报备
     */
    @GetMapping("/isReport")
    public R isReport(Integer userId) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        boolean equals = fmt.format(new Date()).equals(fmt.format(bizHealthService.findLastTime(userId)));
        return R.ok().setData(equals);
    }
}
