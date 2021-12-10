package com.zs.xinguanmaterialmanager.service;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * (TbImage)表服务接口
 *
 * @author makejava
 * @since 2021-12-06 20:32:37
 */
public interface TbImageService {
    /**
     * 上传头像到oss，返回图片地址
     *
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file) throws IOException;

    /**
     * 查询数据
     */
    List<TbImage> queryAll();

    /**
     * 分页查询
     */
    PageInfo<TbImage> findAllTbImageByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过图片路径，图片类型或者图片后缀名进行模糊查询
     */
    List<TbImage> queryAllLike(TbImage tbImage);

    /**
     * 通过图片路径，图片类型或者图片后缀名进行模糊查询并且分页
     */
    PageInfo<TbImage> queryAllLikeByPage(Integer pageNum, Integer pageSize, TbImage tbImage);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
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
