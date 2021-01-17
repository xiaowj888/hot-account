package com.wind.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @ClassName AccountException
 * @Description TODO
 * @Author xiaowj
 * @Date DATE{TIME}
 */
public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }

    public static enum Enum{
        ACCOUNT_UPDATE_ERROE("500","账户更新错误,错误详情%s")
        ;
        String code;
        String msg;

        Enum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public void excpt(String msg){
            throw new AccountException(String.format("{code:%s,msg:%s}",code,String.format(this.msg,msg)));
        }
    }


}
