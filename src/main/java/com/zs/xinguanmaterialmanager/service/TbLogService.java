package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbLog;

/**
 * 操作日志表(TbLog)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:39
 */
public interface TbLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    TbLog queryById(Long id);

    /**
     * 新增数据
     *
     * @param tbLog 实例对象
     * @return 实例对象
     */
    TbLog insert(TbLog tbLog);

    /**
     * 修改数据
     *
     * @param tbLog 实例对象
     * @return 实例对象
     */
    TbLog update(TbLog tbLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
