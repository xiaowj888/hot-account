/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved.
 * <p>
 * This code is the confidential and proprietary information of
 * Hzins. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Hzins,http://www.hzins.com.
 */
package com.wind.config.db;

import com.github.pagehelper.PageHelper;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * <p>
 * 复用下老代码懒得改了
 * </p>
 * @author
 * @date 2017年8月21日 上午10:51:59
 * @version
 */

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.wind.**.dao"}, sqlSessionTemplateRef = "cdwSqlSessionTemplate")
public class DataSourceConfig {
    @Bean(name = "cdwDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.account")
    public DataSource ddbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean(name = "cdwSqlSessionFactory")
    public SqlSessionFactory ddbSqlSessionFactory(@Qualifier("cdwDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setPlugins(new Interceptor[]{pageHelper()});
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mapper/**/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "cdwSqlSessionTemplate")
    public SqlSessionTemplate ddbSqlSessionTemplate(@Qualifier("cdwSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
 