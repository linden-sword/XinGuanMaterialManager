package com.zs.xinguanmaterialmanager.controller;

import com.github.pagehelper.PageInfo;
import com.zs.xinguanmaterialmanager.entity.TbImage;
import com.zs.xinguanmaterialmanager.service.TbImageService;
import com.zs.xinguanmaterialmanager.util.R;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 * (TbImage)控制层
 *
 * @author Zanson
 * @since 2021-12-06 20:32:38
 */
@RestController
@RequestMapping("/XinGuan/tbImage")
@CrossOrigin
public class TbImageController {
    @Resource
    private TbImageService tbImageService;

    /**
     * 文件上传并将详情写入数据库
     */
    @Transactional
    @PostMapping
    public R upload(MultipartFile[] file) throws IOException {
        for (MultipartFile imgFile : file) {
            BufferedImage img = ImageIO.read(imgFile.getInputStream());
            String path = tbImageService.uploadFile(imgFile);
            int width = img.getWidth();
            int height = img.getHeight();
            long size = imgFile.getSize() / 1024;

            String suffix = "";
            int i = path.lastIndexOf('.');
            if (i > 0) {
                suffix = path.substring(i + 1);
            }
            String media_type = suffix.toUpperCase();
            TbImage tbImage = new TbImage(path, size, media_type, suffix, height, width, new Date());

            tbImageService.insert(tbImage);
        }
        return R.ok().setData(new Date());
    }

    /**
     * 图片分页展示
     */
    @GetMapping
    public R queryAll(Integer pageNum, Integer pageSize) {
        PageInfo<TbImage> allTbImageByPage = tbImageService.findAllTbImageByPage(pageNum, pageSize);
        if (!allTbImageByPage.getList().isEmpty()) {
            return R.ok().setData(allTbImageByPage);
        }
        return R.fail();
    }

    /**
     * 图片删除
     */
    @DeleteMapping({"{id}"})
    public R deleteImage(@PathVariable("id") Long id) {
        tbImageService.deleteById(id);
        return R.ok();
    }

    /**
     * 图片模糊查询并且分页展示
     */
    @GetMapping("/findImageList")
    public R findNeed(Integer pageNum, Integer pageSize, TbImage tbImage) {
        PageInfo<TbImage> allTbImageLikeByPage = tbImageService.queryAllLikeByPage(pageNum, pageSize, tbImage);
        if (!allTbImageLikeByPage.getList().isEmpty()) {
            return R.ok().setData(allTbImageLikeByPage);
        }
        return R.fail();
    }
}