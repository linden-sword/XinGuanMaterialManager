package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizOutStock)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:27
 */
public class BizOutStock implements Serializable {
    private static final long serialVersionUID = 698313548022029340L;

    private Long id;
    /**
     * 出库单
     */
    private String outNum;
    /**
     * 出库类型:0:直接出库,1:审核出库
     */
    private Integer type;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 出库时间
     */
    private Date createTime;
    /**
     * 出库总数
     */
    private Integer productNumber;
    /**
     * 消费者id
     */
    private Long consumerId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态:0:正常入库,1:已进入回收,2:等待审核
     */
    private Integer status;
    /**
     * 紧急程度:1:不急,2:常规,3:紧急4:特急
     */
    private Integer priority;

    private String address;

    private String contact;

    private String name;

    private String phone;

    private Integer sort;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BizOutStock() {
    }

    public BizOutStock(Long id, String outNum, Integer type, String operator, Date createTime, Integer productNumber, Long consumerId, String remark, Integer status, Integer priority) {
        this.id = id;
        this.outNum = outNum;
        this.type = type;
        this.operator = operator;
        this.createTime = createTime;
        this.productNumber = productNumber;
        this.consumerId = consumerId;
        this.remark = remark;
        this.status = status;
        this.priority = priority;
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

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}

