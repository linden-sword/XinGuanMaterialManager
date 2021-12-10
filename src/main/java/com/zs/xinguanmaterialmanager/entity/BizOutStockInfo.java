package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizOutStockInfo)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:29
 */
public class BizOutStockInfo implements Serializable {
    private static final long serialVersionUID = 907355975943224337L;

    private Long id;

    private String outNum;

    private String pNum;

    private Integer productNumber;

    private Date createTime;

    private Date modifiedTime;

    public BizOutStockInfo() {
    }

    public BizOutStockInfo(String outNum, String pNum, Integer productNumber, Date createTime, Date modifiedTime) {
        this.outNum = outNum;
        this.pNum = pNum;
        this.productNumber = productNumber;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutNum() {
        return outNum;
    }

    public void setOutNum(String outNum) {
        this.outNum = outNum;
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

