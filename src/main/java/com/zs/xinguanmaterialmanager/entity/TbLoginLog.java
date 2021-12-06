package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志表(TbLoginLog)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:40
 */
public class TbLoginLog implements Serializable {
    private static final long serialVersionUID = 970499434283193865L;
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 登录地点
     */
    private String location;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 操作系统
     */
    private String userSystem;
    /**
     * 浏览器
     */
    private String userBrowser;


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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserSystem() {
        return userSystem;
    }

    public void setUserSystem(String userSystem) {
        this.userSystem = userSystem;
    }

    public String getUserBrowser() {
        return userBrowser;
    }

    public void setUserBrowser(String userBrowser) {
        this.userBrowser = userBrowser;
    }

}

