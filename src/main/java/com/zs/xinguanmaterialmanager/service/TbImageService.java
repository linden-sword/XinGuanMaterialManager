package com.zs.xinguanmaterialmanager.service;

import com.zs.xinguanmaterialmanager.entity.TbImage;

/**
 * (TbImage)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:37
 */
public interface TbImageService {

    /**
     * 通过ID查询单条数据
     *
     * @param Zanson 主键
     * @return 实例对象
     */
    TbImage queryById(Long id);

    /**
     * 新增数据
     *
     * @param tbImage 实例对象
     * @return 实例对象
     */
    TbImage insert(TbImage tbImage);

    /**
     * 修改数据
     *
     * @param tbImage 实例对象
     * @return 实例对象
     */
    TbImage update(TbImage tbImage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
