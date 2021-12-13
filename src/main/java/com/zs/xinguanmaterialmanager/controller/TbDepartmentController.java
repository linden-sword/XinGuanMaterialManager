package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbDepartment;
import com.zs.xinguanmaterialmanager.service.TbDepartmentService;
import com.zs.xinguanmaterialmanager.util.R;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (TbDepartment)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:37
 */
@RestController
@RequestMapping("/XinGuan/department")
public class TbDepartmentController {
    //孙某
    @Resource
    private TbDepartmentService tbDepartmentService;

    @GetMapping("/edit/{id}")
    public R edit(@PathVariable("id") long id) {
        TbDepartment tbDepartment = tbDepartmentService.edit(id);
        if (tbDepartment != null) {
            return R.ok().setData(tbDepartment);
        } else {
            return R.fail().setData(null);
        }
    }

    @GetMapping("/findDepartmentList")
    public R findDepartmentList(TbDepartment tbDepartment, int pageNum, int pageSize) {
        PageInfo pageInfo = tbDepartmentService.findDepartmentList(tbDepartment, pageSize, pageNum);
        if (!pageInfo.getList().isEmpty()) {
            return R.ok().setData(pageInfo);
        } else {
            return R.fail().setData(null);
        }
    }

    @GetMapping("/findAll")
    public R findAll() {
        List<TbDepartment> tbDepartmentList = tbDepartmentService.findAll();
        if (tbDepartmentList.size() > 0) {
            return R.ok().setData(tbDepartmentList);
        } else {
            return R.fail().setData(null);
        }
    }


    // 导出excel表格？
    @GetMapping("/excel")
    public void excel(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"编号", "办公电话", "部门名", "创建时间", "修改时间", "地址"};
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格，设置表格名称为"XX表"
        HSSFSheet sheet = workbook.createSheet("用户表");
        //查询所有数据
        List<TbDepartment> tbDepartmentList = tbDepartmentService.findAll();
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
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        for (TbDepartment tbDepartment : tbDepartmentList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(tbDepartment.getId() + ""));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(tbDepartment.getPhone()));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(tbDepartment.getName()));
            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(sdf.format(tbDepartment.getCreateTime())));
            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(sdf.format(tbDepartment.getModifiedTime())));
            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(tbDepartment.getAddress()));
            rowNum++;
        }
        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");
        //这后面可以设置导出Excel的名称，此例中名为student.xls
        response.setHeader("Content-disposition", "attachment;filename=user.xls");
        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
    }


    @PostMapping("/add")
    public R add(@RequestBody TbDepartment tbDepartment) {
        tbDepartment.setCreateTime(new Date());
        tbDepartment.setModifiedTime(new Date());
        int i = tbDepartmentService.add(tbDepartment);
        if (i > 0) {
            return R.ok().setData(tbDepartment);
        } else {
            return R.fail().setData(null);
        }
    }

    @PutMapping("/update/{id}")
    public R update(@PathVariable("id") long id, TbDepartment tbDepartment) {
        tbDepartment.setModifiedTime(new Date());
        System.out.println(tbDepartment.toString());
        int i = tbDepartmentService.update(id,tbDepartment);
        TbDepartment edit = tbDepartmentService.edit(id);
        if (i > 0) {
            return R.ok().setData(edit);
        } else {
            return R.fail().setData(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable("id") long id) {
        int i = tbDepartmentService.deleteById(id);
        if (i > 0) {
            return R.ok().setData(i);
        } else {
            return R.fail().setData(null);
        }
    }
}
