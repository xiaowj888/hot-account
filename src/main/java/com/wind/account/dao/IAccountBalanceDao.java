package com.wind.account.dao;

import com.wind.account.domain.AccountBalanceDO;
import com.wind.account.dto.AccountUpdateDTO;

public interface IAccountBalanceDao {
    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insert(AccountBalanceDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insertSelective(AccountBalanceDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    AccountBalanceDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKeySelective(AccountBalanceDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKey(AccountBalanceDO record);



    /**
    * @description 更新账户余额
    * @date 2021/1/16 13:47
    * @params [updateDto]
    * @return int
    **/
    int updateAccountBalance(AccountUpdateDTO updateDto);

    /**
    * @description for update
    * @date 2021/1/17 13:42
    * @params [id]
    * @return com.wind.account.domain.AccountBalanceDO
    **/
    AccountBalanceDO selectByPrimaryKeyLock(Long id);
}