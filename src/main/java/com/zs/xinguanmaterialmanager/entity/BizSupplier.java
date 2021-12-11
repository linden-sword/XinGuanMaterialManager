package com.zs.xinguanmaterialmanager.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizSupplier)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:34
 */

public class BizSupplier implements Serializable {
    private static final long serialVersionUID = -19229311616532787L;


    private Long id;
    /**
     * 供应商名称
     */

    private String name;
    /**
     * 供应商地址
     */

    private String address;
    /**
     * 供应商邮箱
     */

    private String email;
    /**
     * 供应商电话
     */

    private String phone;


    private Date createTime;


    private Date modifiedTime;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 联系人
     */
    @ApiModelProperty(name = "contact", value = "联系人")
    private String contact;

    public BizSupplier() {
    }

    public BizSupplier(Long id, String name, String address, String email, String phone, Date createTime, Integer sort, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
        this.sort = sort;
        this.contact = contact;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

