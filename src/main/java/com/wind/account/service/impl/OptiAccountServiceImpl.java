package com.wind.account.service.impl;

import com.wind.account.builder.AccountWaterBuilder;
import com.wind.account.dao.IAccountBalanceDao;
import com.wind.account.domain.AccountBalanceDO;
import com.wind.account.domain.AccountWaterDO;
import com.wind.account.dto.AccountAtomOpDTO;
import com.wind.account.dto.AccountUpdateDTO;
import com.wind.account.service.IAccountService;
import com.wind.account.service.inner.AccountInnerService;
import com.wind.exception.AccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName OptiAccountServiceImpl
 * @Description 使用乐观锁机制实现
 * @Author xiaowj
 * @Date DATE{TIME}
 */
@Service
public class OptiAccountServiceImpl implements IAccountService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IAccountBalanceDao  accountBalanceDao;

    @Resource
    private AccountWaterBuilder accountWaterBuilder;

    @Resource
    private AccountInnerService accountInnerService;

    @Override
    public int balance(AccountAtomOpDTO atomDto){
        AccountBalanceDO curBalance = accountBalanceDao.selectByPrimaryKey(atomDto.getAccountId());
        if(null == curBalance){
            AccountException.Enum.ACCOUNT_UPDATE_ERROE.excpt("账户不存在");
        }
        AccountUpdateDTO updateDto = AccountUpdateDTO.createBuilder()
                .atomInfo(atomDto)
                .currentBanlance(curBalance).build();
        AccountWaterDO curWater = accountWaterBuilder.buildAccountWater(atomDto,curBalance);
        return  accountInnerService.updateAccountWithWater(updateDto,curWater);
    }
}
