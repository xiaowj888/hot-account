package com.wind.account.dao;

import com.wind.account.domain.AccountInfoDO;

public interface IAccountInfoDao {
    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int deleteByPrimaryKey(Long accountId);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insert(AccountInfoDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insertSelective(AccountInfoDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    AccountInfoDO selectByPrimaryKey(Long accountId);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKeySelective(AccountInfoDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKey(AccountInfoDO record);
}