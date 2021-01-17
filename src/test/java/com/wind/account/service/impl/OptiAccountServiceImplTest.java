package com.wind.account.service.impl;
import com.wind.account.dao.IAccountBalanceDao;
import com.wind.account.domain.AccountAtomOrderDO;
import com.wind.account.domain.AccountBalanceDO;
import com.wind.account.dto.AccountAtomOpDTO;
import com.wind.account.service.IAccountService;
import com.wind.enums.AtomTypeEnum;
import com.wind.web.WebApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.CountDownLatch;


@SpringBootTest(classes = WebApplication.class,properties = {"classpath:conf/env/datasource.properties", "classpath:conf/env/config.properties","classpath:conf/env/spring-boot.properties"})
public class OptiAccountServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected static int _W = 10000;

    @Resource
    private OptiAccountServiceImpl optiAccountService;

    @Resource
    private IAccountBalanceDao accountBalanceDao;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;




    protected IAccountService getAccountService() {
        return optiAccountService;
    }

    @Test
    public void insertAccount(){
        AccountBalanceDO record = new AccountBalanceDO();
        record.setAccountId(0L);
        record.setProductId(0L);
        record.setFroz(0L);
        record.setBalance(0L);
        record.setVersion(0L);
        record.setRemark("初始化账户");
        accountBalanceDao.insert(record);
    }

    @Test
    public void add() {
        AccountAtomOrderDO atomOrder = getAccountAtomOrderDO();
        AccountAtomOpDTO atomDto = AccountAtomOpDTO.createBuilder().fromAtomOrder(atomOrder).build();
        optiAccountService.balance(atomDto);
    }


    @Test
    public void addPerformanceTest() {
        int perThreadSize = 10 * _W;
        multiThreadExecute(perThreadSize,getAccountAtomOrderDO());
    }

    @Test
    public void subPerformanceTest() {
        int perThreadSize = 10 * _W;
        AccountAtomOrderDO atomOrder = getAccountAtomOrderDO();
        atomOrder.setAtomType(AtomTypeEnum.SUB.name());
        multiThreadExecute(perThreadSize,atomOrder);
    }





    @Test
    public void addPerformance1Test() {
        taskExecutor.setCorePoolSize(100);
        taskExecutor.setMaxPoolSize(100);
        int perThreadSize = 100 * _W;
        multiThreadExecute(perThreadSize,getAccountAtomOrderDO());

    }

    protected void multiThreadExecute(int perThreadSize,AccountAtomOrderDO atomOrder) {
        StopWatch mainWatch = new StopWatch();
        mainWatch.start("addPerformanceTest");
        CountDownLatch countDownLatch = new CountDownLatch(taskExecutor.getCorePoolSize());

        for (int i = 0; i < taskExecutor.getCorePoolSize(); i++) {
            taskExecutor.execute(() -> {
                StopWatch threadWatch = new StopWatch();
                threadWatch.start(Thread.currentThread().getName());
                try {
                    for (int j = 0; j < perThreadSize; j++) {
                        getAccountService().balance(AccountAtomOpDTO.createBuilder()
                                .fromAtomOrder(atomOrder).build());
                    }
                } catch (Exception e) {
                    logger.warn("execute err with param ", e);
                } finally {
                    threadWatch.stop();
                    logger.info(threadWatch.prettyPrint());
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.warn("execute with timeout ",e);
        }
        mainWatch.stop();
        taskExecutor.shutdown();
        logger.info(mainWatch.prettyPrint());
    }
    protected AccountAtomOrderDO getAccountAtomOrderDO() {
        AccountAtomOrderDO atomOrder = new AccountAtomOrderDO();
        atomOrder.setAtomId(0L);
        atomOrder.setAccountId(1L);
        atomOrder.setAccountName("account000");
        atomOrder.setProductId(0L);
        atomOrder.setProductName("prodcut000");
        atomOrder.setOrgCode("0");
        atomOrder.setOrgName("org000");
        atomOrder.setAtomType(AtomTypeEnum.ADD.name());
        atomOrder.setAmt(1L);
        atomOrder.setStatus("");
        atomOrder.setRemark("");
        atomOrder.setCreateTime(new Date());
        atomOrder.setUpdateTime(new Date());
        return atomOrder;
    }


}