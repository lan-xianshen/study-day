package com.lan.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author jianglin.lan
 * @title: MainConfigTX
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/2610:02
 */
@EnableTransactionManagement
@Configuration
public class MainConfigTX {
    @Bean("dataSource")
    public DataSource dataSource () throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser ("root");
        dataSource.setPassword ("root");
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setDriverClass ("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate () throws PropertyVetoException {
        return new JdbcTemplate (dataSource ());
    }

    @Bean
    public PlatformTransactionManager transactionManager (DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager ();
        transactionManager.setDataSource (dataSource);
        return transactionManager;
    }
}
