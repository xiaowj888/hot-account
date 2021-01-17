package com.wind.account.dao;

import com.wind.account.domain.AccountWaterDO;

public interface IAccountWaterDao {
    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insert(AccountWaterDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insertSelective(AccountWaterDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    AccountWaterDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKeySelective(AccountWaterDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKey(AccountWaterDO record);
}