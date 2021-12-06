package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbLoginLog;

/**
 * 登录日志表(TbLoginLog)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:40
 */
public interface TbLoginLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    TbLoginLog queryById(Long id);

    /**
     * 新增数据
     *
     * @param tbLoginLog 实例对象
     * @return 实例对象
     */
    TbLoginLog insert(TbLoginLog tbLoginLog);

    /**
     * 修改数据
     *
     * @param tbLoginLog 实例对象
     * @return 实例对象
     */
    TbLoginLog update(TbLoginLog tbLoginLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
