package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizInStockInfo)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:26
 */
public class BizInStockInfo implements Serializable {
    private static final long serialVersionUID = 967047582439812113L;

    private Long id;
    /**
     * 入库单编号
     */
    private String inNum;
    /**
     * 商品编号
     */
    private String pNum;
    /**
     * 数量
     */
    private Integer productNumber;

    private Date createTime;

    private Date modifiedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInNum() {
        return inNum;
    }

    public void setInNum(String inNum) {
        this.inNum = inNum;
    }

    public String getPNum() {
        return pNum;
    }

    public void setPNum(String pNum) {
        this.pNum = pNum;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
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

}

