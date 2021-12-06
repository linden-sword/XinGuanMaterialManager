package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志表(TbLog)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:38
 */
public class TbLog implements Serializable {
    private static final long serialVersionUID = 284583425189469083L;
    /**
     * 日志ID
     */
    private Long id;
    /**
     * 操作用户
     */
    private String username;
    /**
     * 操作内容
     */
    private String operation;
    /**
     * 耗时
     */
    private Object time;
    /**
     * 操作方法
     */
    private String method;
    /**
     * 方法参数
     */
    private String params;
    /**
     * 操作者IP
     */
    private String ip;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 操作地点
     */
    private String location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

