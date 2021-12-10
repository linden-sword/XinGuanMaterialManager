package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;

import java.util.List;

/**
 * 操作日志表(TbLog)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:39
 */
public interface TbLogService {


    PageInfo queryAll(TbLog tbLog,int pageNum,int pageSize);
    /**
     * 新增数据
     *
     * @param tbLog 实例对象
     * @return 实例对象
     */
    TbLog insert(TbLog tbLog);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(long id);

}
