package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbUser;
import com.zs.xinguanmaterialmanager.mapper.TbUserMapper;
import com.zs.xinguanmaterialmanager.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:47
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(Long id) {
        return this.tbUserMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        this.tbUserMapper.insert(tbUser);
        return tbUser;
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser update(TbUser tbUser) {
        this.tbUserMapper.update(tbUser);
        return this.queryById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbUserMapper.deleteById(id) > 0;
    }
}
