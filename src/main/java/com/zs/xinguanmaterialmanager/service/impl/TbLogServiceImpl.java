package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.mapper.TbLogMapper;
import com.zs.xinguanmaterialmanager.service.TbLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 操作日志表(TbLog)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:39
 */
@Service("tbLogService")
public class TbLogServiceImpl implements TbLogService {
    @Resource
    private TbLogMapper tbLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbLog queryById(Long id) {
        return this.tbLogMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbLog insert(TbLog tbLog) {
        this.tbLogMapper.insert(tbLog);
        return tbLog;
    }

    /**
     * 修改数据
     *
     * @param tbLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbLog update(TbLog tbLog) {
        this.tbLogMapper.update(tbLog);
        return this.queryById(tbLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbLogMapper.deleteById(id) > 0;
    }
}
