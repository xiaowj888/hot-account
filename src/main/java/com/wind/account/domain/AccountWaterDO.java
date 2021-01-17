package com.wind.account.domain;

import java.util.Date;

public class AccountWaterDO {
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
     * 原子单ID
     */
    private Long atomId;

    /**
     * 原子类型(ADD,SUB,FROZ,UNFROZ)
     */
    private String atomType;

    /**
     * 操作前余额
     */
    private Long preBalance;

    /**
     * 操作后余额
     */
    private Long aftBalance;

    /**
     * 发生额
     */
    private Long efctBalance;

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

    public Long getAtomId() {
        return atomId;
    }

    public void setAtomId(Long atomId) {
        this.atomId = atomId;
    }

    public String getAtomType() {
        return atomType;
    }

    public void setAtomType(String atomType) {
        this.atomType = atomType == null ? null : atomType.trim();
    }

    public Long getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(Long preBalance) {
        this.preBalance = preBalance;
    }

    public Long getAftBalance() {
        return aftBalance;
    }

    public void setAftBalance(Long aftBalance) {
        this.aftBalance = aftBalance;
    }

    public Long getEfctBalance() {
        return efctBalance;
    }

    public void setEfctBalance(Long efctBalance) {
        this.efctBalance = efctBalance;
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