package com.wind.account.service.retry;

import com.github.rholder.retry.*;
import com.wind.account.service.IAccountService;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AccountRetryBuilder
 * @Description 根据业务规则执行重试操作
 * @Author xiaowj
 * @Date DATE{TIME}
 */
public class AccountRetryBuilder {
    private static final Retryer<Integer> retry = RetryerBuilder.<Integer>newBuilder()
            .retryIfResult(Objects::isNull)
            .retryIfResult(integer -> Objects.equals(integer, 0))
            .retryIfExceptionOfType(Exception.class)
            .withWaitStrategy(WaitStrategies.incrementingWait(10, TimeUnit.MILLISECONDS,10,TimeUnit.MILLISECONDS))
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .build();

    public static IAccountService buildAccountRetry(IAccountService accountService){
        return atomDto -> {
            int result = 0;
            try {
                result = retry.call(() -> accountService.balance(atomDto));
            } catch (ExecutionException | RetryException e) {
                //忽略
            }
            return result;
        };
    }
}
