package com.zs.xinguanmaterialmanager;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.service.TbLogService;
import com.zs.xinguanmaterialmanager.service.TbLoginLogService;
import com.zs.xinguanmaterialmanager.service.impl.TbLogServiceImpl;
import com.zs.xinguanmaterialmanager.service.impl.TbLoginLogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class XinGuanMaterialManagerApplicationTests {
    @Autowired
private   TbLogService tbLogService;
    @Test
    void contextLoads() {
        TbLog t=new TbLog();
//        t.setTime(1111);
t.setOperation("操作名");
        PageInfo pageInfo = tbLogService.queryAll(t, 2, 3);
        System.out.println(pageInfo);
    }

}
