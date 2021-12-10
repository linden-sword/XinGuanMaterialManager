package com.zs.xinguanmaterialmanager.service.impl;

import com.zs.xinguanmaterialmanager.entity.TbImage;
import com.zs.xinguanmaterialmanager.mapper.TbImageMapper;
import com.zs.xinguanmaterialmanager.service.TbImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TbImage)表服务实现类
 *
 * @author Zanson
 * @since 2021-12-06 20:32:37
 */
@Service("tbImageService")
public class TbImageServiceImpl implements TbImageService {
    @Resource
    private TbImageMapper tbImageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbImage queryById(Long id) {
        return this.tbImageMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tbImage 实例对象
     * @return 实例对象
     */
    @Override
    public TbImage insert(TbImage tbImage) {
        this.tbImageMapper.insert(tbImage);
        return tbImage;
    }

    /**
     * 修改数据
     *
     * @param tbImage 实例对象
     * @return 实例对象
     */
    @Override
    public TbImage update(TbImage tbImage) {
        this.tbImageMapper.update(tbImage);
        return this.queryById(tbImage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbImageMapper.deleteById(id) > 0;
    }
}
