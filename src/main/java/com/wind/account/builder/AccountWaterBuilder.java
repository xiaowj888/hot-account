package com.wind.account.builder;

import com.wind.account.domain.AccountBalanceDO;
import com.wind.account.domain.AccountWaterDO;
import com.wind.account.dto.AccountAtomOpDTO;
import org.springframework.stereotype.Component;

/**
 * @ClassName AccountWaterBuilder
 * @Description TODO
 * @Author xiaowj
 * @Date DATE{TIME}
 */
@Component
public class AccountWaterBuilder {


    /**
    * @description 构造账户流水
    * @date 2021/1/16 13:31
    * @params [atomDto, curBalance]
    * @return com.wind.account.domain.AccountWaterDO
    **/
    public AccountWaterDO buildAccountWater(AccountAtomOpDTO atomDto, AccountBalanceDO curBalance) {
        AccountWaterDO water = new AccountWaterDO();
        water.setAccountId(atomDto.getAccountId());
        water.setProductId(atomDto.getProductId());
        water.setAtomId(atomDto.getAtomId());
        water.setAtomType(atomDto.getAtomType().name());
        water.setPreBalance(curBalance.getBalance());
        water.setAftBalance(curBalance.getBalance() + atomDto.getAmtEfct());
        water.setEfctBalance(atomDto.getAmtEfct());
        water.setRemark(atomDto.getAtomType().getDesc());
        return water;
    }
}
