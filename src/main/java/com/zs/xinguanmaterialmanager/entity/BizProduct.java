package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizProduct)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:30
 */
public class BizProduct implements Serializable {
    private static final long serialVersionUID = 869081148026700783L;

    private Long id;
    /**
     * 商品编号
     */
    private String pNum;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 图片
     */
    private String imageUrl;
    /**
     * 规格型号
     */
    private String model;
    /**
     * 计算单位
     */
    private String unit;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 1级分类
     */
    private Long oneCategoryId;
    /**
     * 2级分类
     */
    private Long twoCategoryId;
    /**
     * 3级分类
     */
    private Long threeCategoryId;
    /**
     * 是否删除:1物资正常,0:物资回收,2:物资审核中
     */
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPNum() {
        return pNum;
    }

    public void setPNum(String pNum) {
        this.pNum = pNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Long getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(Long oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public Long getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(Long twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public Long getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(Long threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

