package com.zs.xinguanmaterialmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志表(TbLog)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 操作地点
     */
    private String location;




}

