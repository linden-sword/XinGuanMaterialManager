package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.service.impl.BizSupplierServiceImpl;
import com.zs.xinguanmaterialmanager.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * (BizSupplier)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:35
 */
@RestController
@RequestMapping("/XinGuan/supplier")
@Api(tags = "物资来源管理接口",value = "BizSupplierController")
public class BizSupplierController {
    //fan
    @Autowired
    private BizSupplierServiceImpl bizSupplierService;
    /**
     * 添加物资信息
     * @param bizSupplier 物资对象
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "物资添加",notes = "Material addition")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "物资编号"),
            @ApiImplicitParam(name = "Name", value = "物资名称")
    })
    public R insert(@RequestBody BizSupplier bizSupplier){
        int i = bizSupplierService.insert(bizSupplier);
        if (i==1){
            return  R.ok().setData("添加成功!");
        }
        if(i != 1){
            return  R.fail().setData("添加失败!");
        }
        return R.exp().setData("系统异常!");
    }

    /**
     * 根据id删除物资信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(long id){
        int i = bizSupplierService.deleteById(id);
        if (i==1){
            return  R.ok().setData("删除成功!");
        }
        if(i != 1){
            return  R.fail().setData("删除失败!");
        }
        return R.exp().setData("系统异常!");
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    @GetMapping("/edit")
    public BizSupplier queryById(Long id){
        return bizSupplierService.queryById(id);
    }


    /**
     * 更新信息
     * @param bizSupplier
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody BizSupplier bizSupplier){
        int i = bizSupplierService.update(bizSupplier);
        if (i==1){
            return  R.ok().setData("删除成功!");
        }
        if(i != 1){
            return  R.fail().setData("删除失败!");
        }
        return R.exp().setData("系统异常!");
    }

    /**
     * 查询所有，并分页
     * @param pageNum 分页页数
     * @param pageSize 每页条数
     * @return
     */
    @GetMapping("/findAll")
    public PageInfo<BizSupplier> findAll(int pageNum,int pageSize){
        return bizSupplierService.findAll(pageNum,pageSize);
    }

    /**
     * 根据name模糊查询
     * @param pageNum 分页页数
     * @param pageSize 每页条数
     * @param
     * @return
     */
    @GetMapping("/findSupplierList")
    public PageInfo<BizSupplier> findSupplierList(int pageNum,int pageSize,BizSupplier bizSupplier){
        Map map =new HashMap();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        return bizSupplierService.findSupplierList(map,bizSupplier);
    }
//fan
}
