package com.zs.xinguanmaterialmanager.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbImage;
import com.zs.xinguanmaterialmanager.mapper.TbImageMapper;
import com.zs.xinguanmaterialmanager.service.TbImageService;
import com.zs.xinguanmaterialmanager.util.AliyunOssUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

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

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        //通过常量工具类获取配置的参数值
        String endpoint = AliyunOssUtil.END_POINT;
        String accessKeyId = AliyunOssUtil.KEY_ID;
        String accessKeySecret = AliyunOssUtil.KEY_SECRET;
        String bucketName = AliyunOssUtil.BUCKET_NAME;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 获取上传文件的输入流
        InputStream inputStream = file.getInputStream();
        //获取上传文件的名称
        String fileName = file.getOriginalFilename();
        //1. 在文件名称里面添加随机唯一值，让每个文件都不一样
        //2. 把文件按照日期进行分类
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //DateTime是org.joda.time包下的
        fileName = new DateTime().toString("yyyy/MM/dd") + "/" + uuid + new DateTime().toString("HHmmss") + "-" + fileName;

        // 第一个参数：bucketName
        // 第二个参数：保存在oss中的目录+名称
        // 第三个参数：输入流
        ossClient.putObject(bucketName, fileName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //返回路径需要拼接
        String url = String.format("https://%s.%s/%s", bucketName, endpoint, fileName);

        return url;
    }

    /**
     * 查找所有
     *
     * @return List<TbImage>
     */
    @Override
    public List<TbImage> queryAll() {
        return this.tbImageMapper.queryAll();
    }

    /**
     * 分页
     *
     * @param pageNum
     * @param pageSize
     * @return PageInfo<>
     */
    @Override
    public PageInfo<TbImage> findAllTbImageByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbImage> tbImages = tbImageMapper.queryAll();
        return new PageInfo<>(tbImages);
    }

    /**
     * 通过图片路径，图片类型或者图片后缀名进行模糊查询
     */
    @Override
    public List<TbImage> queryAllLike(TbImage tbImage) {
        return tbImageMapper.queryAllLike(tbImage);
    }

    /**
     * 通过图片路径，图片类型或者图片后缀名进行模糊查询分页
     */
    @Override
    public PageInfo<TbImage> queryAllLikeByPage(Integer pageNum, Integer pageSize, TbImage tbImage) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbImage> tbImages = tbImageMapper.queryAllLike(tbImage);
        return new PageInfo<>(tbImages);
    }

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
