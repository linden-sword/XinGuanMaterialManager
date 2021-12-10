package com.zs.xinguanmaterialmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志表(TbLoginLog)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbLoginLog implements Serializable {//孙某
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
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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



}

