package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizProductCategory)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:31
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

}

