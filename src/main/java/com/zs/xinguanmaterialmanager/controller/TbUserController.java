package com.zs.xinguanmaterialmanager.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbDepartment;
import com.zs.xinguanmaterialmanager.entity.TbMenu;
import com.zs.xinguanmaterialmanager.entity.TbRole;
import com.zs.xinguanmaterialmanager.entity.TbUser;
import com.zs.xinguanmaterialmanager.service.TbDepartmentService;
import com.zs.xinguanmaterialmanager.service.TbUserService;
import com.zs.xinguanmaterialmanager.util.JWTUtil;
import com.zs.xinguanmaterialmanager.util.R;
import org.apache.poi.hssf.usermodel.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表(TbUser)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:47
 */
@RestController
public class TbUserController {

    @Resource
    private TbUserService tbUserService;
    @Resource
    private TbDepartmentService departmentService;

    /**
     * 添加用户
     *
     * @param tbUser
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 14:53 2021/12/7
     **/
    @PostMapping("/XinGuan/user/add")
    public R addUser(TbUser tbUser) {
        if (tbUserService.insert(tbUser) > 0) {
            return R.ok().setData("添加用户成功");
        }
        return R.fail().setData("添加用户失败");
    }

    /**
     * 删除用户ByID
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 14:56 2021/12/7
     **/
    @DeleteMapping("/XinGuan/user/delete/{id}")
    public R delById(@PathVariable("id") Long id) {
        if (tbUserService.deleteById(id)) {
            return R.ok().setData("删除用户成功");
        }
        return R.ok().setData("删除用户失败");
    }

    /**
     * 编辑用户(通过ID查询用户,编辑前的查询回填)
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 15:02 2021/12/7
     **/
    @GetMapping("/XinGuan/user/edit/{id}")
    public R findUserById(@PathVariable("id") Long id) {
        TbUser tbUser = tbUserService.queryById(id);
        if (tbUser != null) {
            return R.ok().setData(tbUser);
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
    @PostMapping("/XinGuan/user/excel")
    public void excelDownload(HttpServletResponse response) throws IOException {
        //表头数据
        String[] header = {"编号", "用户名", "昵称", "邮箱", "电话号码", "创建时间", "修改时间", "性别", "密码盐值", "用户类型", "用户密码", "出生日期", "头像Url"};
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格，设置表格名称为"XX表"
        HSSFSheet sheet = workbook.createSheet("用户表");
        //查询所有数据
        List<TbUser> tbUserList = tbUserService.findUserList(null);
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
        for (TbUser user : tbUserList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(user.getId() + ""));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(user.getUsername()));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(user.getNickname()));
            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(user.getEmail()));
            row1.createCell((short) 4).setCellValue(new HSSFRichTextString(user.getPhoneNumber()));
            row1.createCell((short) 5).setCellValue(new HSSFRichTextString(user.getCreateTime() + ""));
            row1.createCell((short) 6).setCellValue(new HSSFRichTextString(user.getModifiedTime() + ""));
            row1.createCell((short) 7).setCellValue(new HSSFRichTextString(user.getSex() + ""));
            row1.createCell((short) 8).setCellValue(new HSSFRichTextString(user.getSalt()));
            row1.createCell((short) 9).setCellValue(new HSSFRichTextString(user.getType() + ""));
            row1.createCell((short) 10).setCellValue(new HSSFRichTextString(user.getPassword()));
            row1.createCell((short) 11).setCellValue(new HSSFRichTextString(user.getBirth() + ""));
            row1.createCell((short) 12).setCellValue(new HSSFRichTextString(user.getAvatar()));
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


    /**
     * 加载菜单(通过用户查询菜单树)(登录后 : 加载当前用户的菜单树)
     *
     * @param request
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 16:31 2021/12/10
     **/
    @GetMapping("/XinGuan/user/findMenu")
    public R findMenu(HttpServletRequest request) {
        //没有参数，需要通过Token获取
        String jwtToken = request.getHeader("token");
        DecodedJWT decodedJWT = JWTUtil.parseData(jwtToken);
        //从JWT中解析到username
        String username = decodedJWT.getClaim("username").asString();
        TbUser tbUser = tbUserService.findByUsername(username);
        List<TbMenu> menuList = tbUserService.findMenu(tbUser.getId());
        return R.ok().setData(menuList);
    }


    /**
     * 用户列表(二合一：有参数是分页模糊查询，没参数是分页查询全部)
     *
     * @param pageNum, pageSize, tbUser
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 15:46 2021/12/7
     **/
    @GetMapping("/XinGuan/user/findUserList")
    public R findUserList(int pageNum, int pageSize, TbUser tbUser) {
        //设置分页规则
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbUser> pageInfo = new PageInfo<>(tbUserService.findUserList(tbUser));
        return R.ok().setData(pageInfo);
    }


    /**
     * 用户信息(首页头像右边的登录信息:头像、账号、昵称、部门、角色)
     *
     * @param request
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 9:29 2021/12/10
     **/
    @GetMapping("/XinGuan/user/info")
    public R userLoginInfo(HttpServletRequest request) {
        //没有参数，需要通过Token获取
        String jwtToken = request.getHeader("token");
        DecodedJWT decodedJWT = JWTUtil.parseData(jwtToken);
        //从JWT中解析到username
        String username = decodedJWT.getClaim("username").asString();
        //通过username查user、通过department_id查部门名称、通过user_role查角色、通过role查角色名称
        TbUser tbUser = tbUserService.findByUsername(username);
        //部门
        TbDepartment department = departmentService.queryById(tbUser.getDepartmentId());
        //角色
        List<TbRole> tbRoleList = tbUserService.findUserRoles(tbUser.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("avatar", tbUser.getAvatar());
        map.put("username", tbUser.getUsername());
        map.put("nickname", tbUser.getUsername());
        map.put("department", department.getName());
        map.put("roleList", tbRoleList);
        return R.ok().setData(map);
    }


    /**
     * 用户登入(登录成功后返回JWT token)
     *
     * @param tbUser, request
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 9:19 2021/12/10
     **/
    @PostMapping("/XinGuan/user/login")
    public R login(TbUser tbUser, HttpServletRequest request) {
        //登录
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        //封装凭证
        UsernamePasswordToken token = new UsernamePasswordToken(tbUser.getUsername(), tbUser.getPassword());
        //设置当前登录的用户
        request.setAttribute("username", tbUser.getUsername());
        System.out.println("///=== LoginUser: " + request.getAttribute("username"));
        //身份认证
        //认证失败
        try {
            currentUser.login(token);
        } catch (UnknownAccountException e) {
            return R.fail().setData("error:用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return R.fail().setData("error：密码错误");
        } catch (Exception e) {
            return R.fail().setData("error: 未知异常");
        }
        return R.ok().setData("login  ok");
    }


    /**
     * 更新用户(修改用户信息)
     *
     * @param id, tbUser
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 16:21 2021/12/7
     **/
    @PutMapping("/XinGuan/user/update/{id}")
    public R updateUser(@PathVariable("id") Long id, TbUser tbUser) {
        if (tbUserService.update(tbUser) > 0) {
            return R.ok().setData("更新用户成功");
        }
        return R.fail().setData("更新用户失败");
    }


    /**
     * 用户状态(禁用or启用)
     *
     * @param id, status
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 16:29 2021/12/7
     **/
    @PutMapping("/XinGuan/user/updateStatus/{id}/{status}")
    public R updateStatus(@PathVariable("id") Long id, @PathVariable("status") boolean status) {
        TbUser tbUser = new TbUser();
        tbUser.setId(id);
        if (status) {
            tbUser.setStatus(0);
            if (tbUserService.update(tbUser) > 0) {
                return R.ok().setData("禁用成功");
            }
        } else {
            tbUser.setStatus(1);
            if (tbUserService.update(tbUser) > 0) {
                return R.ok().setData("启用成功");
            }
        }
        return R.fail().setData("操作失败");
    }


    /**
     * 给用户分配角色
     *
     * @param id, rids
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 17:18 2021/12/10
     **/
    @PostMapping("/XinGuan/user/{id}/assignRoles")
    public R fenPeiRole(@PathVariable("id") Long id, Long[] rids) {
        for (Long rid : rids) {
            if (tbUserService.insertUserRole(id, rid) == 0) {
                return R.fail().setData("Fail");
            }
        }
        return R.ok().setData("OK");
    }


    /**
     * 查询用户已有角色(从user_role里面查所有的roleID，然后去role表里查对应的role)
     *
     * @param id
     * @return com.zs.xinguanmaterialmanager.util.R
     * @author Zanson
     * @since 17:31 2021/12/7
     **/
    @GetMapping("/XinGuan/user/{id}/roles")
    public R queryRoles(@PathVariable("id") Long id, Long[] rids) {
        List<TbRole> tbRoleList = tbUserService.findUserRoles(id);
        return R.ok().setData(tbRoleList);
    }

}
