package com.zs.xinguanmaterialmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbImage)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    public TbImage(String path, Long size, String mediaType, String suffix, Integer height, Integer width, Date createTime) {
        this.path = path;
        this.size = size;
        this.mediaType = mediaType;
        this.suffix = suffix;
        this.height = height;
        this.width = width;
        this.createTime = createTime;
    }
}