package com.zs.xinguanmaterialmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbLoginLog;
import com.zs.xinguanmaterialmanager.mapper.TbLoginLogMapper;
import com.zs.xinguanmaterialmanager.service.TbLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志表(TbLoginLog)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:40
 */
@Service
public class TbLoginLogServiceImpl implements TbLoginLogService {
    @Resource
    private TbLoginLogMapper tbLoginLogMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public PageInfo queryAll(TbLoginLog tbLoginLog, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbLoginLog> tbLoginLogList = tbLoginLogMapper.queryAll(tbLoginLog);
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(tbLoginLogList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param tbLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbLoginLog insert(TbLoginLog tbLoginLog) {
        tbLoginLogMapper.insert(tbLoginLog);
        return tbLoginLog;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(long id) {
        System.out.println("ser" + id);
        int i = tbLoginLogMapper.deleteById(id);
        return i;
    }
}
