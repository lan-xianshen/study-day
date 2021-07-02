package com.lan.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
 *
 *  环境搭建：
 *      1、导入相关依赖
 *          数据源、数据库驱动、Spring-jdbc模块
 *      2、配置数据源、JdbcTemplate(Spring提供的简化数据库操作的工具)操作数据
 *
 *
 *
 */
@ComponentScan("com.lan.tx")
@EnableTransactionManagement
@Configuration
public class MainConfigTX {
    @Bean("dataSource")
    public DataSource dataSource () throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser ("root");
        dataSource.setPassword ("123456");
        dataSource.setJdbcUrl ("jdbc:mysql://47.105.46.3:3306/oclorderdatebase?useUnicode=true&characterEncoding=utf8&autoReconnect=true");
        dataSource.setDriverClass ("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate () throws PropertyVetoException {
        //Spring对 @Configuration类会特殊处理：给容器中加组件的方法，多次调用都只是从容器中找组件
        return new JdbcTemplate (dataSource ());
    }

    @Bean
    public PlatformTransactionManager transactionManager (DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager ();
        transactionManager.setDataSource (dataSource);
        return transactionManager;
    }
}
