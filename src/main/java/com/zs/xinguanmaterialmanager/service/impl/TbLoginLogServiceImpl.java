package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import com.zs.xinguanmaterialmanager.mapper.TbLoginLogMapper;
import com.zs.xinguanmaterialmanager.service.TbLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录日志表(TbLoginLog)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:40
 */
@Service("tbLoginLogService")
public class TbLoginLogServiceImpl implements TbLoginLogService {
    @Resource
    private TbLoginLogMapper tbLoginLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbLoginLog queryById(Long id) {
        return this.tbLoginLogMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbLoginLog insert(TbLoginLog tbLoginLog) {
        this.tbLoginLogMapper.insert(tbLoginLog);
        return tbLoginLog;
    }

    /**
     * 修改数据
     *
     * @param tbLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbLoginLog update(TbLoginLog tbLoginLog) {
        this.tbLoginLogMapper.update(tbLoginLog);
        return this.queryById(tbLoginLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbLoginLogMapper.deleteById(id) > 0;
    }
}
