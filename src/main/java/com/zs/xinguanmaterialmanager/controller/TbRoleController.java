package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbMenu;
import com.zs.xinguanmaterialmanager.entity.TbRole;
import com.zs.xinguanmaterialmanager.service.TbRoleService;
import com.zs.xinguanmaterialmanager.util.R;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 角色表(TbRole)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:43
 */
@RestController
@RequestMapping("/tbRole")
public class TbRoleController {

    @Resource
    private TbRoleService tbRoleService;

    /**
     * 添加角色
     *
     * @param tbRole
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 19:44 2021/12/7
     **/
    @PostMapping("/XinGuan/role/add")
    public R addRole(@RequestBody TbRole tbRole) {
        if (tbRoleService.insert(tbRole) > 0) {
            return R.ok().setData("添加角色成功");
        }
        return R.fail().setData("添加角色失败");
    }


    /**
     * 角色授权
     *
     * @param id, mids
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 15:19 2021/12/10
     **/
    @PostMapping("/XinGuan/role/authority/{id}")
    public R addRoleMenu(@PathVariable("id") Long id, Long[] mids) {
        for (Long mid : mids) {
            if (tbRoleService.addRoleMenu(id, mid) == 0) {
                return R.fail().setData("Fail");
            }
        }
        return R.ok().setData("OK");
    }


    /**
     * 删除角色
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 19:47 2021/12/7
     **/
    @DeleteMapping("/XinGuan/role/delete/{id}")
    public R delRoleById(@PathVariable("id") Long id) {
        if (tbRoleService.deleteById(id)) {
            return R.ok().setData("删除角色成功");
        }
        return R.fail().setData("删除角色失败");
    }

    /**
     * 编辑用户,根据ID更新角色信息(修改之前，先查后改)
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 21:57 2021/12/7
     **/
    @GetMapping("/XinGuan/role/edit/{id}")
    public R editFindRoleById(@PathVariable("id") Long id) {
        TbRole tbRole = tbRoleService.queryById(id);
        return R.ok().setData(tbRole);
    }


    /**
     * Excel表格导出接口
     *
     * @param response response对象
     * @throws IOException 抛IO异常
     * @author Zanson
     * @since 10:48 2021/12/9
     **/
    @PostMapping("/XinGuan/role/excel")
    public void excelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"编号", "角色名称", "备注信息", "创建时间", "修改时间", "禁用状态"};
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格，设置表格名称为"XX表"
        HSSFSheet sheet = workbook.createSheet("角色表");
        //查询所有数据
        List<TbRole> tbRoleList = tbRoleService.queryAll(null);
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
        for (TbRole role : tbRoleList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(role.getId() + ""));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(role.getRoleName()));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(role.getRemark()));
            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(role.getCreateTime() + ""));
            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(role.getModifiedTime() + ""));
            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(role.getStatus() + ""));
            rowNum++;
        }
        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");
        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=role.xls");
        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
    }


    /**
     * 角色列表(分页模糊查询二合一)
     *
     * @param pageNum, pageSize, tbRole
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 22:06 2021/12/7
     **/
    @GetMapping("/XinGuan/role/findRoleList")
    public R findRoleList(int pageNum, int pageSize, @RequestBody TbRole tbRole) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbRole> pageInfo = new PageInfo<>(tbRoleService.queryAll(tbRole));
        return R.ok().setData(pageInfo);
    }


    /**
     * 角色菜单(根据角色查询角色的权限)
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 15:38 2021/12/10
     **/
    @GetMapping("/XinGuan/role/findRoleMenu/{id}")
    public R findRoleMenu(@PathVariable("id") Long id) {
        List<TbMenu> menuList = tbRoleService.queryMenuByRoleId(id);
        return R.ok().setData(menuList);
    }


    /**
     * 更新角色
     *
     * @param id, tbRole
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 22:09 2021/12/7
     **/
    @PutMapping("/XinGuan/role/update/{id}")
    public R updateRole(@PathVariable("id") Long id, @RequestBody TbRole tbRole) {
        if (tbRoleService.update(tbRole) > 0) {
            return R.ok().setData("更新角色成功");
        }
        return R.fail().setData("更新角色失败");
    }


    /**
     * 更新状态(禁用or启用)
     *
     * @param id, status
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 22:15 2021/12/7
     **/
    @PutMapping("/XinGuan/role/updateStatus/{id}/{status}")
    public R updateStatus(@PathVariable("id") Long id, @PathVariable("status") boolean status) {
        TbRole tbRole = new TbRole();
        tbRole.setId(id);
        if (status) {
            tbRole.setStatus(0);
            if (tbRoleService.update(tbRole) > 0) {
                return R.ok().setData("禁用角色成功");
            }
        } else {
            tbRole.setStatus(1);
            if (tbRoleService.update(tbRole) > 0) {
                return R.ok().setData("启用角色成功");
            }
        }
        return R.fail().setData("操作失败");
    }

}