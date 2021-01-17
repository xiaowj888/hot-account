package com.wind.account.service.impl;

import com.wind.account.domain.AccountAtomOrderDO;
import com.wind.account.service.IAccountService;
import com.wind.enums.AtomTypeEnum;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class PessAccountServiceImplTest extends OptiAccountServiceImplTest {

    @Resource
    private PessAccountServiceImpl pessAccountService;



    protected IAccountService getAccountService() {
        return pessAccountService;
    }


    @Test
    public void addPerformanceTest() {
        int perThreadSize = 10 * _W;
        AccountAtomOrderDO atomOrder = getAccountAtomOrderDO();
        atomOrder.setAccountId(2L);
        atomOrder.setProductId(1L);
        multiThreadExecute(perThreadSize, atomOrder);
    }


    @Test
    public void subPerformanceTest() {
        int perThreadSize = 10 * _W;
        AccountAtomOrderDO atomOrder = getAccountAtomOrderDO();
        atomOrder.setAccountId(2L);
        atomOrder.setProductId(1L);
        atomOrder.setAtomType(AtomTypeEnum.SUB.name());
        multiThreadExecute(perThreadSize,atomOrder);
    }

}
