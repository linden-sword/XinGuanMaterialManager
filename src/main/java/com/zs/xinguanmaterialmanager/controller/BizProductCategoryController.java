package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizProductCategory;
import com.zs.xinguanmaterialmanager.entity.BizSupplier;
import com.zs.xinguanmaterialmanager.service.BizProductCategoryService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BizProductCategory)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:32
 */
@RestController
@RequestMapping("/XinGuan/productCategory")
public class BizProductCategoryController {
    @Resource
    private BizProductCategoryService bizProductCategoryService;
//fan
    /**
     * 添加分类
     * @param bizProductCategory
     * @return
     */
    @PostMapping("/add")
    public R insert(@RequestBody BizProductCategory bizProductCategory){
        if (bizProductCategory.getPid()==null) {
            bizProductCategory.setPid(Long.valueOf(0));
        }
        int i = bizProductCategoryService.insert(bizProductCategory);
        if (i==1){
            return R.ok().setData("添加成功！");
        }
        if (i != 1){
            return R.fail().setData("添加失败！");
        }
        return R.exp().setData("系统异常!");
    }

    /**
     * 查询所有分类
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findAll")
    public PageInfo<BizProductCategory> findAll(int pageNum, int pageSize){
        return bizProductCategoryService.findAll(pageNum,pageSize);
    }

    /**
     * 查询所有子类
     * @param pageNum
     * @param pageSize
     * @param pid
     * @return
     */
    @GetMapping("/findProductCategoryLis")
    public PageInfo<BizSupplier> findSupplierList(int pageNum,int pageSize,long pid){
        Map map =new HashMap();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("pid",pid);
        return bizProductCategoryService.findAllByPid(map);
    }


    /**
     * 根据id 查询单个信息
     * @param id
     * @return
     */
    @GetMapping("/edit")
    public BizProductCategory queryById(long id){
        return bizProductCategoryService.queryById(id);

    }

    /**
     * 更新分类
     * @param bizProductCategory
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody BizProductCategory bizProductCategory){
        int i = bizProductCategoryService.update(bizProductCategory);
        if (i==1){
            return R.ok().setData("修改成功！");
        }
        if (i != 1){
            return R.fail().setData("修改失败！");
        }
        return R.exp().setData("系统异常!");
    }

    /**
     * 删除  根据id删除分类或物资
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(long id){
//        long id  一级id
        //查询的pid等于一级id的个数
        List<BizProductCategory> byId = bizProductCategoryService.findById(id);


        if (byId.size()==0){
            int i = bizProductCategoryService.deleteById(id);
            if (i==0) {
                //删除失败
                return R.fail().setData("删除失败");
            }
            if(i!=0) {
                //删除成功
                return R.ok().setData("删除成功！");
            }
//        }else{
//            for(BizProductCategory bizProductCategory : byId){
//                List<BizProductCategory> byId1 = bizProductCategoryService.findById(bizProductCategory.getId());
//                if (byId1.size()==1){
//                    for (BizProductCategory productCategory : byId1) {
//                        List<BizProductCategory> byId2 = bizProductCategoryService.findById(bizProductCategory.getId());
//                        if (byId2.size() == 1) {
//                            int i = bizProductCategoryService.deleteById(productCategory.getId());
//                            int j = bizProductCategoryService.deleteById(bizProductCategory.getId());
//                            int l = bizProductCategoryService.deleteById(id);
//                            if (i == 1 && j == 1 && l == 1) {
//                                //删除成功
//                                return R.ok().setData("删除成功！");
//                            }
//                            if (i != 1 && j != 1 && l != 1) {
//                                //删除失败
//                                return R.fail().setData("删除失败");
//                            }
//                        }
//                    }
                }else {
                    return R.fail().setData("删除失败，您删除的分类中包含多个物资，不能删除！！！！！");
//                }
//            }
        }
       return R.exp().setData("系统异常");
    }
}
//fan

