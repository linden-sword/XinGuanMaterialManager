package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Classname outStockVO
 * @Description TODO
 * @Date 2021/12/8 16:56
 * @Created by dell
 */
public class outStockVO implements Serializable {

    private String address;

    private Long consumerId;

    private Date createTime;

    private Long id;

    private String name;

    private String operator;

    private String outNum;

    private String phone;

    private Integer priority;

    private Integer productNumber;

    private List<Products> products;

    private String remark;

    private Integer sort;

    private Integer status;

    private Integer type;

    private String contact;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOutNum() {
        return outNum;
    }

    public void setOutNum(String outNum) {
        this.outNum = outNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "outStockVO{" +
                "address='" + address + '\'' +
                ", consumerId=" + consumerId +
                ", createTime=" + createTime +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", operator='" + operator + '\'' +
                ", outNum='" + outNum + '\'' +
                ", phone='" + phone + '\'' +
                ", priority=" + priority +
                ", productNumber=" + productNumber +
                ", products=" + products +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
