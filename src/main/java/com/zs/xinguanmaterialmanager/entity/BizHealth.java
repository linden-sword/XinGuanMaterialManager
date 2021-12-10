package com.zs.xinguanmaterialmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (BizHealth)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

}