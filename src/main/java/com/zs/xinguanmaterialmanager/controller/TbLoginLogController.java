package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import com.zs.xinguanmaterialmanager.service.TbLoginLogService;
import com.zs.xinguanmaterialmanager.util.IpUtil;
import com.zs.xinguanmaterialmanager.util.R;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * 登录日志表(TbLoginLog)表控制层
 *
 * @author makejava
 * @since 2021-12-06 16:59:30
 */
@RestController
@RequestMapping("/XinGuan/loginLog")
public class TbLoginLogController {
//    孙某
    /**
     * 服务对象
     */
    @Resource
    private TbLoginLogService tbLoginLogService;


    /**
     * 日志列表
     *
     * @return
     */
    @GetMapping("/findLoginLogList")
    public R queryAll(TbLoginLog tbLoginLog, int pageSize, int pageNum) {
        PageInfo pageInfo = tbLoginLogService.queryAll(tbLoginLog, pageSize, pageNum);
        if (!pageInfo.getList().isEmpty()) {
            return R.ok().setData(pageInfo);
        } else {
            return R.fail().setData(null);
        }
    }

    /**
     * 新增数据
     * 用户登入报表
     *
     * @param tbLoginLog 实体
     * @return 新增结果
     */
    @PostMapping("/loginReport")
    public R add(TbLoginLog tbLoginLog, HttpServletRequest request) {
        tbLoginLog.setLoginTime(new Date());
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        String clientType = userAgent.getOperatingSystem().getDeviceType().toString();
        LOGGER.info("clientType = " + clientType);   //客户端类型  手机、电脑、平板
        String location = userAgent.getOperatingSystem().getName();
        LOGGER.info("location = " + location);    //操作系统类型
        String ip = IpUtil.getIpAddr(request);
        LOGGER.info("ip = " + ip);    //请求ip
        String browser = userAgent.getBrowser().toString();
        LOGGER.info("browser = " + browser);
        tbLoginLog.setLocation(location);
        tbLoginLog.setIp(IpUtil.getIpAddr(request));
        tbLoginLog.setUserSystem(clientType);
        tbLoginLog.setUserBrowser(browser);
        TbLoginLog i = tbLoginLogService.insert(tbLoginLog);
        if (i != null) {
            return R.ok().setData(i);
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
        System.out.println(id);
        int i = tbLoginLogService.deleteById(id);
        System.out.println(i);
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
        int t = 0;
        if (ids.isEmpty()) {
            return R.fail().setData(t);
        } else {
            for (Object o : ids) {
                deleteById(Integer.parseInt(o.toString()));
                t++;
            }
            System.out.println(t);
            return R.ok().setData(t);

        }
    }
}