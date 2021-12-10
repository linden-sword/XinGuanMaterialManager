package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;

import java.util.List;

/**
 * 登录日志表(TbLoginLog)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:40
 */
public interface TbLoginLogService {


    PageInfo queryAll(TbLoginLog loginLog,int pageNum,int pageSize);
    /**
     * 新增数据
     *
     * @param tbLoginLog 实例对象
     * @return 实例对象
     */
    TbLoginLog insert(TbLoginLog tbLoginLog);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(long id);

}
