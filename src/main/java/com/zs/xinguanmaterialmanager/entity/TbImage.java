package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbImage)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:37
 */
public class TbImage implements Serializable {
    private static final long serialVersionUID = -47247321295882288L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 图片路径
     */
    private String path;
    /**
     * 图片大小
     */
    private Long size;
    /**
     * 图片类型
     */
    private String mediaType;
    /**
     * 图片后缀
     */
    private String suffix;
    /**
     * 图片高度
     */
    private Integer height;
    /**
     * 图片宽度
     */
    private Integer width;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

