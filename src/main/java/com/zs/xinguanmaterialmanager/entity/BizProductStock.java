package com.zs.xinguanmaterialmanager.entity;

import java.io.Serializable;

/**
 * (BizProductStock)实体类
 *
 * @author makejava
 * @since 2021-12-06 20:32:32
 */
public class BizProductStock implements Serializable {
    private static final long serialVersionUID = 376616415365755690L;

    private Long id;

    private String pNum;
    /**
     * 商品库存结余
     */
    private Long stock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPNum() {
        return pNum;
    }

    public void setPNum(String pNum) {
        this.pNum = pNum;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

}

