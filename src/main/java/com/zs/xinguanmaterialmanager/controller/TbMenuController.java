package com.zs.xinguanmaterialmanager.controller;

import com.zs.xinguanmaterialmanager.entity.TbMenu;
import com.zs.xinguanmaterialmanager.service.TbMenuService;
import com.zs.xinguanmaterialmanager.util.R;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单表(TbMenu)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:42
 */
@RestController
public class TbMenuController {

    @Resource
    private TbMenuService tbMenuService;

    /**
     * 新增菜单
     *
     * @param tbMenu
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 11:30 2021/12/7
     **/
    @PostMapping("/XinGuan/menu/add")
    public R addMenu(@RequestBody TbMenu tbMenu) {
        if (tbMenuService.insert(tbMenu) > 0) {
            return R.ok().setData("添加成功");
        }
        return R.fail().setData("添加失败");
    }


    /**
     * 删除菜单(遍历当前节点是否存在子节点，如果存在递归删除)
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 11:34 2021/12/7
     **/
    @DeleteMapping("/XinGuan/menu/delete/{id}")
    public R deleteById(@PathVariable("id") Long id) {
        //先判断是根节点还是叶子节点
        if (tbMenuService.queryById(id).getType().equals("0")) {
            //找到它的子节点
            List<TbMenu> tbMenuList = tbMenuService.queryByParentId(id);
            for (TbMenu tbMenu : tbMenuList) {
                //判断是不是叶子节点
                if (tbMenuService.queryById(tbMenu.getId()).getType().equals("0")) {
                    List<TbMenu> tbMenuList1 = tbMenuService.queryByParentId(tbMenu.getId());
                    for (TbMenu tbMenu1 : tbMenuList1) {
                        tbMenuService.deleteById(tbMenu1.getId());
                        System.out.println("///===Del:" + tbMenu1);
                    }
                }
                tbMenuService.deleteById(tbMenu.getId());
                System.out.println("///===Del:" + tbMenu);
            }
        }
        //叶子 : 直接删除
        if (tbMenuService.deleteById(id)) {
            return R.ok().setData("删除成功");
        }
        System.out.println("///===Del:" + tbMenuService.queryById(id));
        return R.ok().setData("删除成功");
    }


    /**
     * 根据ID获取菜单详情,(修改之前的查询和回填用到的)
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 11:42 2021/12/7
     **/
    @GetMapping("/XinGuan/menu/edit/{id}")
    public R queryById(@PathVariable("id") Long id) {
        TbMenu tbMenu = tbMenuService.queryById(id);
        if (tbMenu != null) {
            return R.ok().setData(tbMenu);
        }
        return R.fail().setData(null);
    }


    /**
     * Excel表格导出接口
     *
     * @param response response对象
     * @throws IOException 抛IO异常
     * @author Zanson
     * @since 10:48 2021/12/9
     **/
    @GetMapping("/XinGuan/menu/excel")
    public void excelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"编号", "父级ID", "菜单名称", "菜单URL", "菜单图标", "是否展开", "菜单类型", "排序", "创建时间", "修改时间", "是否可用", "权限编码"};
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格，设置表格名称为"XX表"
        HSSFSheet sheet = workbook.createSheet("菜单表");
        //查询所有数据
        List<TbMenu> tbMenuList = tbMenuService.queryAll();
        int rowNum = 1;
        //设置表格列宽度为X个字节
        sheet.setDefaultColumnWidth(30);
        //创建第一行表头
        HSSFRow headRow = sheet.createRow(0);
        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
        for (int i = 0; i < header.length; i++) {
            //创建一个单元格
            HSSFCell cell = headRow.createCell((short) i);
            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);
            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
        }
        for (TbMenu menu : tbMenuList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(menu.getId()+""));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(menu.getParentId()+""));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(menu.getMenuName()));
            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(menu.getUrl()));
            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(menu.getIcon()));
            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(menu.getOpen()+""));
            row1.createCell((short) 6).setCellValue(new HSSFRichTextString(menu.getType()+""));
            row1.createCell((short) 7).setCellValue(new HSSFRichTextString(menu.getOrderNum()+""));
            row1.createCell((short) 8).setCellValue(new HSSFRichTextString(menu.getCreateTime()+""));
            row1.createCell((short) 9).setCellValue(new HSSFRichTextString(menu.getModifiedTime()+""));
            row1.createCell((short) 10).setCellValue(new HSSFRichTextString(menu.getAvailable()+""));
            row1.createCell((short) 11).setCellValue(new HSSFRichTextString(menu.getPerms()));
            rowNum++;
        }
        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");
        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=menu.xls");
        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
    }


    /**
     * 加载菜单树(实体类添加一个List属性)
     *
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 11:38 2021/12/8
     **/
    @GetMapping("/XinGuan/menu/tree")
    public R tree() {
        //查询所有菜单
        List<TbMenu> menuList = tbMenuService.queryAll();
        //查出所有根级菜单
        List<TbMenu> parentList = new ArrayList<>();
        for (TbMenu tbMenu : menuList) {
            if (tbMenu.getParentId() == 0) {
                parentList.add(tbMenu);
            }
        }
        //调用递归方法:循环获取子菜单
        for (TbMenu tbMenu : parentList) {
            tbMenu.setChildren(getChildrenMenuList(tbMenu.getId(), menuList));
        }
        return R.ok().setData(parentList);
    }


    /**
     * 递归子菜单
     *
     * @param id, tbMenuList
     * @return java.util.List<com.zs.xinguanmaterialmanager.entity.TbMenu>
     * @author Zanson
     * @since 11:27 2021/12/8
     **/
    private List<TbMenu> getChildrenMenuList(Long id, List<TbMenu> tbMenuList) {
        //子菜单
        List<TbMenu> childrenMenuList = new ArrayList<>();
        for (TbMenu tbMenu : tbMenuList) {
            //判断是当前节点的子节点
            if (tbMenu.getParentId().equals(id)) {
                childrenMenuList.add(tbMenu);
                //查找当前节点的子节点，存到childrenList属性中
                tbMenu.setChildren(tbMenuService.queryByParentId(tbMenu.getId()));
            }
        }
        for (TbMenu tbMenu2 : childrenMenuList) {
            //判断是菜单不是按钮(叶子节点)
            if (tbMenu2.getType().equals("0")) {
                //递归:查找当前节点的子节点，存到childrenList属性中
                tbMenu2.setChildren(getChildrenMenuList(tbMenu2.getId(), tbMenuList));
            }
        }
        if (childrenMenuList.size() == 0) {
            return null;
        }
        return childrenMenuList;
    }


    /**
     * 更新菜单
     *
     * @param tbMenu
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 19:14 2021/12/7
     **/
    @PutMapping("/XinGuan/menu/update")
    public R updateById(@RequestBody TbMenu tbMenu) {
        if (tbMenuService.update(tbMenu) > 0) {
            return R.ok().setData("更新成功");
        }
        return R.fail().setData("更新失败");
    }

}
