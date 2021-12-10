package com.zs.xinguanmaterialmanager.vo;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 羽程
 * @create: 2021-12-07 14:32
 **/
@Data
public class InStockInfoPro2VO {
    private String name;
    /**
     * 供应商地址
     */
    private String address;
    /**
     * 供应商电话
     */
    private String phone;
    /**
     * 联系人
     */
    private String contact;


    List<InStockInfoProVO> inStockInfoProVOS;
}
