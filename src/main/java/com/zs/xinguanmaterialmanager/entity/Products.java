package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;

/**
 * @Classname Products
 * @Description TODO
 * @Date 2021/12/8 18:48
 * @Created by dell
 */
public class Products implements Serializable {

    private Long productId;
    private Integer productNumber;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
}
