package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import com.zs.xinguanmaterialmanager.service.TbLogService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志表(TbLog)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:39
 */
@RestController
@RequestMapping("/XinGuan/log")
public class TbLogController {
    //14、系统⽇志接⼝ :
// Log Controller DELETE /api/log/batchDelete/{ids} 批量删除
// DELETE /api/log/delete/{id} 删除⽇志
// GET /api/log/findLogList ⽇志列表
    @Resource
    private TbLogService tbLogService;

    /**
     * 日志列表
     *
     * @return
     */

    @GetMapping("/findLogList")
    public R queryAll(TbLog tbLog, int pageNum, int pageSize) {
        PageInfo pageInfo = tbLogService.queryAll(tbLog, pageNum, pageSize);
        if (!pageInfo.getList().isEmpty()) {
            return R.ok().setData(pageInfo);
        } else {
            return R.fail().setData(null);
        }
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{id}")
    public R deleteById(@PathVariable("id") long id) {
        int i = tbLogService.deleteById(id);
        if (i > 0) {
            return R.ok().setData(i);
        } else {
            return R.fail().setData(null);
        }
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/batchDelete/{ids}")
    public R deleteByIds(@PathVariable List ids) {
        if (ids.isEmpty()) {
            return R.fail().setData(0);
        } else {
            for (Object o : ids) {
                deleteById(Integer.parseInt(o.toString()));
            }
            System.out.println(ids.size());
            return R.ok().setData(ids.size());
        }
    }


}
