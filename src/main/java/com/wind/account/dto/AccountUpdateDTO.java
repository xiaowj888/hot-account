package com.wind.account.dto;

import com.wind.account.domain.AccountAtomOrderDO;
import com.wind.account.domain.AccountBalanceDO;
import com.wind.dto.BaseDTO;
import com.wind.enums.AtomTypeEnum;

/**
 * @ClassName AccountAtomOpDTO
 * @Description 账户更新操作
 * @Author xiaowj
 * @Date DATE{TIME}
 */
public class AccountUpdateDTO extends BaseDTO {

    public static class AccountUpdateDtoBuilder{
        private AccountUpdateDTO dto = new AccountUpdateDTO();
        public AccountUpdateDtoBuilder atomInfo(AccountAtomOpDTO atomDto){
            dto.accountId = atomDto.getAccountId();
            dto.amtEfct = atomDto.getAmtEfct();
            return this;
        }

        public AccountUpdateDtoBuilder currentBanlance(AccountBalanceDO balanceDO){
            dto.balance = balanceDO.getBalance();
            dto.version = balanceDO.getVersion();
            return this;
        }

        public AccountUpdateDTO build(){
            return dto;
        }
    }

    public static AccountUpdateDtoBuilder createBuilder(){
        return new AccountUpdateDtoBuilder();
    }


    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 版本信息
     */
    private Long version;



    /**
     * 操作金额变化量
     */
    private Long amtEfct;

}
