package com.zs.xinguanmaterialmanager.util;


import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.service.TbLogService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyIntercepter implements HandlerInterceptor {
    @Autowired

    private TbLogService tbLogService;
    private StopWatch stopWatch;
    private TbLog tbLog;
    String username = "111";
    Date date;

    String operation;
    String method;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求到达controller之前，需要做的处理");
        stopWatch = new StopWatch();
        stopWatch.start();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("controller处理后，需要做的处理");
        method = request.getRequestURI();
        if (method.indexOf("/XinGuan/menu/add") >= 0) {
            operation = "新增菜单";
        }
        if (method.indexOf("/XinGuan/menu/delete") >= 0) {
            operation = "删除菜单";
        }
        if (method.indexOf("/XinGuan/menu/edit") >= 0) {
            operation = "菜单详情";
        }
        if (method.indexOf("/XinGuan/menu/excel") >= 0) {
            operation = "到处excel";
        }
        if (method.indexOf("/XinGuan/menu/tree") >= 0) {
            operation = "加载菜单树";
        }
        if (method.indexOf("/XinGuan/menu/update") >= 0) {
            operation = "更新菜单";
        }
        //登入日志接口：Login Log Controller
        if (method.indexOf("/XinGuan/loginLog/batchDelete") >= 0) {
            operation = "批量删除日志";
        }
        if (method.indexOf("/XinGuan/loginLog/delete") >= 0) {
            operation = "删除日志";
        }
        if (method.indexOf("/XinGuan/loginLog/findLoginLogList") >= 0) {
            operation = "日志列表";
        }
        if (method.indexOf("/XinGuan/loginLog/loginReport") >= 0)
        //第三方API接口：Other API Controller
        {
            operation = "登入报表";
        }
        if (method.indexOf("/XinGuan/music/getPlayList") >= 0) {
            operation = "getPlayList";
        }
        if (method.indexOf("/XinGuan/rumor/detail") >= 0) {
            operation = "detail";
        }
        if (method.indexOf("/XinGuan/rumor/list") >= 0) {
            operation = "list";
        }
        //健康上报接口：Health Controller
        if (method.indexOf("/XinGuan/health/history") >= 0) {
            operation = "健康记录";
        }
        if (method.indexOf("/XinGuan/health/isReport") >= 0) {
            operation = "是否报备";
        }
        if (method.indexOf("/XinGuan/health/report") >= 0) {
            operation = "健康上报";
        }
        //文件上传接口：Upload Controller
        if (method.indexOf("/XinGuan/upload/delete") >= 0) {
            operation = "删除图片";
        }
        if (method.indexOf("/XinGuan/upload/findImageList") >= 0) {
            operation = "附件列表";
        }
        if (method.indexOf("/XinGuan/upload/image") >= 0) {
            operation = "上传文件";
        }
        //物资出库接口：Out Stock Controller
        if (method.indexOf("/XinGuan/outStock/addOutStock") >= 0) {
            operation = "提交发放单";
        }
        if (method.indexOf("/XinGuan/outStock/back") >= 0) {
            operation = "恢复数据";
        }
        if (method.indexOf("/XinGuan/outStock/delete") >= 0) {
            operation = "删除物资发放单";
        }
        if (method.indexOf("/XinGuan/outStock/detail") >= 0) {
            operation = "发放单明细";
        }
        if (method.indexOf("/XinGuan/outStock/findOutStockList") >= 0) {
            operation = "出库单列表";
        }
        if (method.indexOf("/XinGuan/outStock/publish") >= 0) {
            operation = "入库审核";
        }
        if (method.indexOf("/XinGuan/outStock/remove") >= 0) {
            operation = "移入回收站";
        }
        //物资来源接口：Supplier Controller
        if (method.indexOf("/XinGuan/supplier/add") >= 0) {
            operation = "添加来源";
        }
        if (method.indexOf("/XinGuan/supplier/delete") >= 0) {
            operation = "删除来源";
        }
        if (method.indexOf("/XinGuan/supplier/edit") >= 0) {
            operation = "编辑来源";
        }
        if (method.indexOf("/XinGuan/supplier/findAll") >= 0) {
            operation = "所有来源";
        }
        if (method.indexOf("/XinGuan/supplier/findSupplierList") >= 0) {
            operation = "来源列表";
        }
        if (method.indexOf("/XinGuan/supplier/update") >= 0) {
            operation = "更新来源";
        }
        //物资分类接口：Product Category Controller
        if (method.indexOf("/XinGuan/productCategory/add") >= 0) {
            operation = "添加分类";
        }
        if (method.indexOf("/XinGuan/productCategory/categoryTree") >= 0) {
            operation = "分类树形结构";
        }
        if (method.indexOf("/XinGuan/productCategory/delete") >= 0) {
            operation = "删除分类";
        }
        if (method.indexOf("/XinGuan/productCategory/edit") >= 0) {
            operation = "编辑分类";
        }
        if (method.indexOf("/XinGuan/productCategory/findAll") >= 0) {
            operation = "所有分类";
        }
        if (method.indexOf("/XinGuan/productCategory/findProductCategoryList") >= 0) {
            operation = "分类列表";
        }
        if (method.indexOf("/XinGuan/productCategory/getParentCategoryTree") >= 0) {
            operation = "父级分类树";
        }
        if (method.indexOf("/XinGuan/productCategory/update") >= 0) {
            operation = "更新分类";
        }
        //物资去向接口：Consumer Controller
        if (method.indexOf("/XinGuan/consumer/add") >= 0) {
            operation = "添加去向";
        }
        if (method.indexOf("/XinGuan/consumer/delete") >= 0) {
            operation = "删除去向";
        }
        if (method.indexOf("/XinGuan/consumer/edit") >= 0) {
            operation = "编辑去向";
        }
        if (method.indexOf("/XinGuan/consumer/findAll") >= 0) {
            operation = "所有去向";
        }
        if (method.indexOf("/XinGuan/consumer/findConsumerList") >= 0) {
            operation = "去向列表";
        }
        if (method.indexOf("/XinGuan/consumer/update") >= 0) {
            operation = "更新去向";
        }
        //物资入库接口：In Stock Controller
        if (method.indexOf("/XinGuan/inStock/addIntoStock") >= 0) {
            operation = "物资入库";
        }
        if (method.indexOf("/XinGuan/inStock/back") >= 0) {
            operation = "恢复数据";
        }
        if (method.indexOf("/XinGuan/inStock/delete") >= 0) {
            operation = "删除物资入库单";
        }
        if (method.indexOf("/XinGuan/inStock/detail") >= 0) {
            operation = "入库单明细";
        }
        if (method.indexOf("/XinGuan/inStock/findInStockList") >= 0) {
            operation = "入库单列表";
        }
        if (method.indexOf("/XinGuan/inStock/publish") >= 0) {
            operation = "入库审核";
        }
        if (method.indexOf("/XinGuan/inStock/remove") >= 0) {
            operation = "移入回收站";
        }
        //物资资料接口：Product Controller
        if (method.indexOf("/XinGuan/product/add") >= 0) {
            operation = "添加物资";
        }
        if (method.indexOf("/XinGuan/product/back") >= 0) {
            operation = "恢复物资";
        }
        if (method.indexOf("/XinGuan/product/delete") >= 0) {
            operation = "删除物资";
        }
        if (method.indexOf("/XinGuan/product/edit") >= 0) {
            operation = "编辑物资";
        }
        if (method.indexOf("/XinGuan/product/findAllStocks") >= 0) {
            operation = "全部库存";
        }
        if (method.indexOf("/XinGuan/product/findProductList") >= 0) {
            operation = "屋子列表";
        }
        if (method.indexOf("/XinGuan/product/findProductStocks") >= 0) {
            operation = "库存列表";
        }
        if (method.indexOf("/XinGuan/product/findProducts") >= 0) {
            operation = "可入库物资列表";
        }
        if (method.indexOf("/XinGuan/product/publish") >= 0) {
            operation = "物资添加审核";
        }
        if (method.indexOf("/XinGuan/product/remove") >= 0) {
            operation = "移入回收站";
        }
        if (method.indexOf("/XinGuan/product/update") >= 0) {
            operation = "更新物资";
        }
        //系统部门接口：Department Controller
        if (method.indexOf("/XinGuan/department/add") >= 0) {
            operation = "添加部门";
        }
        if (method.indexOf("/XinGuan/department/delete") >= 0) {
            operation = "删除部门";
        }
        if (method.indexOf("/XinGuan/department/edit") >= 0) {
            operation = "编辑部门";
        }
        if (method.indexOf("/XinGuan/department/excel") >= 0) {
            operation = "导出excel";
        }
        if (method.indexOf("/XinGuan/department/findAll") >= 0) {
            operation = "所有部门";
        }
        if (method.indexOf("/XinGuan/department/findDeanList") >= 0) {
            operation = "部门主任";
        }
        if (method.indexOf("/XinGuan/department/findDepartmentList") >= 0) {
            operation = "部门列表";
        }
        if (method.indexOf("/XinGuan/department/update") >= 0) {
            operation = "更新部门";
        }
        //系统角色接口：Role Controller
        if (method.indexOf("/XinGuan/role/add") >= 0) {
            operation = "添加角色";
        }
        if (method.indexOf("/XinGuan/role/authority") >= 0) {
            operation = "角色授权";
        }
        if (method.indexOf("/XinGuan/role/delete") >= 0) {
            operation = "删除角色";
        }
        if (method.indexOf("/XinGuan/role/edit") >= 0) {
            operation = "编辑用户";
        }
        if (method.indexOf("/XinGuan/role/excel") >= 0) {
            operation = "导出excel";
        }
        if (method.indexOf("/XinGuan/role/findRoleList") >= 0) {
            operation = "角色列表";
        }
        if (method.indexOf("/XinGuan/role/findRoleMenu") >= 0) {
            operation = "角色菜单";
        }
        if (method.indexOf("/XinGuan/role/update") >= 0) {
            operation = "更新角色";
        }
        if (method.indexOf("/XinGuan/role/updateStatus") >= 0) {
            operation = "更新状态";
        }
        //系统日志接口：Log Controller
        if (method.indexOf("/XinGuan/log/batchDelete") >= 0) {
            operation = "批量删除";
        }
        if (method.indexOf("/XinGuan/log/delete") >= 0) {
            operation = "删除日志";
        }
        if (method.indexOf("/XinGuan/log/findLogList") >= 0) {
            operation = "日志列表";
        }
        //系统用户接口：User Controller
        if (method.indexOf("/XinGuan/user/add") >= 0) {
            operation = "添加用户";
        }
        if (method.indexOf("/XinGuan/user/delete") >= 0) {
            operation = "删除用户";
        }
        if (method.indexOf("/XinGuan/user/edit") >= 0) {
            operation = "编辑用户";
        }
        if (method.indexOf("/XinGuan/user/excel") >= 0) {
            operation = "导出excel";
        }
        if (method.indexOf("/XinGuan/user/findMenu") >= 0) {
            operation = "加载菜单";
        }
        if (method.indexOf("/XinGuan/user/findUserList") >= 0) {
            operation = "用户列表";
        }
        if (method.indexOf("/XinGuan/user/info") >= 0) {
            operation = "用户信息";
        }
        if (method.indexOf("/XinGuan/user/login") >= 0) {
            operation = "用户登入";
        }
        if (method.indexOf("/XinGuan/user/update") >= 0) {
            operation = "更新用户";
        }
        if (method.indexOf("/XinGuan/user/updateStatus") >= 0) {
            operation = "用户状态";
        }
        if (method.indexOf("/assignRoles") >= 0) {
            operation = "分配角色";
        }
        if (method.indexOf("/roles") >= 0) {
            operation = "已有角色";
        }
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        String location = userAgent.getOperatingSystem().getName();
        try {
            username = request.getParameter("username");
        }catch (Exception e) {
            e.printStackTrace();
        }

        String queryString = request.getQueryString();
        System.out.println(request.getRequestURI());
        //当前时间
        date = new Date();
        //定时器停止
        stopWatch.stop();
        //if (username != null) {
            tbLog = new TbLog(null, username, operation, stopWatch.getTotalTimeMillis(), method, queryString, IpUtil.getIpAddr(request), date, location);
       // }
        tbLogService.insert(tbLog);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("最后处理");
    }
}