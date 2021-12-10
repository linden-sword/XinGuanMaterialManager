package com.zs.xinguanmaterialmanager.vo;

import com.zs.xinguanmaterialmanager.entity.BizProduct;
import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * @description:
 * @author: 羽程
 * @create: 2021-12-06 20:42
 **/
@Data
public class InStockVO {
    private Long id;
    private String address;
    private String contact;
    private Date createTime;
    private String email;
    private Date modifiedTime;
    private String inNum;
    private String name;
    private String operator;
    private String phone;
    private int productNumber;
    List<BizProduct> product;
    private String remark;
    private int sort;
    private int status;
    private long supplierId;
    private String supplierName;
    private int type;
    private Date startTime;
    private Date endTime;
}
