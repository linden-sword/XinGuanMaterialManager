package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLog;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import com.zs.xinguanmaterialmanager.mapper.TbLogMapper;
import com.zs.xinguanmaterialmanager.service.TbLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
     * 查询所有
     *
     * @return
     */
    @Override
    public PageInfo queryAll(TbLog tbLog, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbLog> tbLogList = tbLogMapper.queryAll(tbLog);
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(tbLogList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param tbLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbLog insert(TbLog tbLog) {
        tbLogMapper.insert(tbLog);
        return tbLog;
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(long id) {

        int i = tbLogMapper.deleteById(id);
        return i;
    }
}
