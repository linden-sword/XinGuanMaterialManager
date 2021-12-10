package com.zs.xinguanmaterialmanager.entity;

import java.util.List;

/**
 * @Classname detailOutStock
 * @Description TODO
 * @Date 2021/12/9 14:48
 * @Created by dell
 */
public class DetailOutStock {

    private BizConsumer consumerVO;

    private List<BizProduct> itemVOS;

    private String operator;

    private String outNum;

    private Integer status;

    private Long total;

    private Integer type;

    public BizConsumer getConsumerVO() {
        return consumerVO;
    }

    public void setConsumerVO(BizConsumer consumerVO) {
        this.consumerVO = consumerVO;
    }

    public List<BizProduct> getItemVOS() {
        return itemVOS;
    }

    public void setItemVOS(List<BizProduct> itemVOS) {
        this.itemVOS = itemVOS;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOutNum() {
        return outNum;
    }

    public void setOutNum(String outNum) {
        this.outNum = outNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
