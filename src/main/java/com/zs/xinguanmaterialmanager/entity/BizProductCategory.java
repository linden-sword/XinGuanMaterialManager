package com.zs.xinguanmaterialmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (BizProductCategory)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizProductCategory implements Serializable {
    private static final long serialVersionUID = 183370887078162633L;
    /**
     * 类别id
     */
    private Long id;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序
     */
    private Integer sort;


    private Date createTime;

    private Date modifiedTime;
    /**
     * 父级分类id
     */
    private Long pid;



    private List<BizProductCategory> children  ;



}

