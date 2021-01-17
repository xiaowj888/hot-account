package com.wind.account.dto;

import com.wind.account.domain.AccountAtomOrderDO;
import com.wind.dto.BaseDTO;
import com.wind.enums.AtomTypeEnum;

/**
 * @ClassName AccountAtomOpDTO
 * @Description 账户原子操作DTO
 * @Author xiaowj
 * @Date DATE{TIME}
 */
public class AccountAtomOpDTO extends BaseDTO {

    public static class AccountAtomDtoBuilder{
        private AccountAtomOpDTO dto = new AccountAtomOpDTO();
        public AccountAtomDtoBuilder fromAtomOrder(AccountAtomOrderDO atomOrder){
            dto.accountId = atomOrder.getAccountId();
            dto.amt = atomOrder.getAmt();
            dto.atomId = atomOrder.getAtomId();
            dto.atomType = AtomTypeEnum.valueOf(atomOrder.getAtomType());
            dto.productId = atomOrder.getProductId();
            return this;
        }
        public AccountAtomOpDTO build(){
            return dto;
        }
    }

    public static AccountAtomDtoBuilder createBuilder(){
        return new AccountAtomDtoBuilder();
    }

    /**
     * 原子单ID
     */
    private Long atomId;

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 原子类型
     */
    private AtomTypeEnum atomType;

    /**
     * 金额
     */
    private Long amt;


    public Long getAmtEfct(){
        return amt * atomType.getType();
    }



    public Long getAtomId() {
        return atomId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getProductId() {
        return productId;
    }

    public AtomTypeEnum getAtomType() {
        return atomType;
    }

    public Long getAmt() {
        return amt;
    }
}
