package com.wind.account.service.inner;

import com.wind.account.dao.IAccountBalanceDao;
import com.wind.account.dao.IAccountWaterDao;
import com.wind.account.domain.AccountWaterDO;
import com.wind.account.dto.AccountUpdateDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.Executors;

/**
 * @ClassName AccountInnerService
 * @Description 事务封装
 * @Author xiaowj
 * @Date DATE{TIME}
 */
@Service
public class AccountInnerService {

    @Resource
    private IAccountBalanceDao accountBalanceDao;

    @Resource
    private IAccountWaterDao accountWaterDao;

    @Transactional(rollbackFor = Exception.class)
    public int updateAccountWithWater(AccountUpdateDTO updateDto, AccountWaterDO curWater) {
       int count = accountBalanceDao.updateAccountBalance(updateDto);
       if(count > 0){
           accountWaterDao.insert(curWater);
       }
       return count;
    }
}
