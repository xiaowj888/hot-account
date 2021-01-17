package com.wind.account.dao;

import com.wind.account.domain.ProductDO;

public interface IProductDao {
    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int deleteByPrimaryKey(Long productId);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insert(ProductDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int insertSelective(ProductDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    ProductDO selectByPrimaryKey(Long productId);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKeySelective(ProductDO record);

    /**
     *
     * @mbg_by_xiaowj 2021-01-16
     */
    int updateByPrimaryKey(ProductDO record);
}