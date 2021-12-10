package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizHealth)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:23
 */
public class BizHealth implements Serializable {
    private static final long serialVersionUID = -78943499428217945L;

    private Long id;

    private String address;

    private Long userId;

    private Integer situation;

    private Integer touch;

    private Integer passby;

    private Integer reception;

    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSituation() {
        return situation;
    }

    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    public Integer getTouch() {
        return touch;
    }

    public void setTouch(Integer touch) {
        this.touch = touch;
    }

    public Integer getPassby() {
        return passby;
    }

    public void setPassby(Integer passby) {
        this.passby = passby;
    }

    public Integer getReception() {
        return reception;
    }

    public void setReception(Integer reception) {
        this.reception = reception;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

