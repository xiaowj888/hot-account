package com.wind.account.dao;

import com.wind.account.domain.AccountAtomOrderDO;

public interface IAccountAtomOrderDao {
    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int deleteByPrimaryKey(Long atomId);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insert(AccountAtomOrderDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insertSelective(AccountAtomOrderDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    AccountAtomOrderDO selectByPrimaryKey(Long atomId);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKeySelective(AccountAtomOrderDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKey(AccountAtomOrderDO record);
}