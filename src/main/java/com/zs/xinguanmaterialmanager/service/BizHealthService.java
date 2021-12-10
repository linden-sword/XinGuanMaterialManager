package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.BizHealth;

import java.util.Date;
import java.util.List;


/**
 * (BizHealth)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:24
 */
public interface BizHealthService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BizHealth queryById(Long id);

    /**
     * 查询数据
     */
    List<BizHealth> queryAll();

    /**
     * 分页查询
     */
    PageInfo<BizHealth> findAllBizHealthByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过userID查询
     */
    List<BizHealth> queryByUserId(Integer userId);

    /**
     * 通过userId查找到打卡最新的时间
     */
    Date findLastTime(Integer userId);

    /**
     * 新增数据
     *
     * @param bizHealth 实例对象
     * @return 实例对象
     */
    BizHealth insert(BizHealth bizHealth);

    /**
     * 修改数据
     *
     * @param bizHealth 实例对象
     * @return 实例对象
     */
    BizHealth update(BizHealth bizHealth);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
