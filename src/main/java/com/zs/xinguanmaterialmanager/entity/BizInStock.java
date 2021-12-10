package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizInStock)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:24
 */
public class BizInStock implements Serializable {
    private static final long serialVersionUID = -62741574833614987L;

    private Object id;
    /**
     * 入库单编号
     */
    private String inNum;
    /**
     * 类型：1：捐赠，2：下拨，3：采购,4:退货入库
     */
    private Integer type;
    /**
     * 操作人员
     */
    private String operator;
    /**
     * 入库单创建时间
     */
    private Date createTime;
    /**
     * 入库单修改时间
     */
    private Date modified;
    /**
     * 物资总数
     */
    private Integer productNumber;
    /**
     * 来源
     */
    private Long supplierId;
    /**
     * 描述信息
     */
    private String remark;
    /**
     * 0:正常入库单,1:已进入回收,2:等待审核
     */
    private Integer status;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getInNum() {
        return inNum;
    }

    public void setInNum(String inNum) {
        this.inNum = inNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

