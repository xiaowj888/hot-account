package com.wind.account.domain;

import java.util.Date;

public class AccountBalanceDO {
    /**
     * 
     */
    private Long id;

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 冻结
     */
    private Long froz;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 版本信息
     */
    private Long version;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getFroz() {
        return froz;
    }

    public void setFroz(Long froz) {
        this.froz = froz;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}