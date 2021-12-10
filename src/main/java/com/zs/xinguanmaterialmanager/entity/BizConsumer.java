package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizConsumer)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:22
 */
public class BizConsumer implements Serializable {
    private static final long serialVersionUID = -82946079247208974L;

    private Long id;
    /**
     * 物资消费方
     */
    private String name;
    /**
     * 地址
     */
    private String address;

    private Date createTime;

    private Date modifiedTime;
    /**
     * 联系电话
     */
    private String phone;

    private Integer sort;
    /**
     * 联系人姓名
     */
    private String contact;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}

