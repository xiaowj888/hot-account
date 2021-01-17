package com.wind.account.domain;

import java.util.Date;

public class AccountAtomOrderDO {
    /**
     * 原子单ID
     */
    private Long atomId;

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 原子类型(ADD,SUB,FROZ,UNFROZ)
     */
    private String atomType;

    /**
     * 金额
     */
    private Long amt;

    /**
     * 状态(INIT,SUCC,FAIL)
     */
    private String status;

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

    public Long getAtomId() {
        return atomId;
    }

    public void setAtomId(Long atomId) {
        this.atomId = atomId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getAtomType() {
        return atomType;
    }

    public void setAtomType(String atomType) {
        this.atomType = atomType == null ? null : atomType.trim();
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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