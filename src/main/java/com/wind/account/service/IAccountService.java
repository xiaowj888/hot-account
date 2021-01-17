package com.wind.account.service;

import com.wind.account.dto.AccountAtomOpDTO;

public interface IAccountService {

    /**
     * @description 账户余额操作
     * @date 2021/1/16 13:51
     * @params [atomDto]
     * @return int 返回账户更新行数
     **/
    int balance(AccountAtomOpDTO atomDto);
}
