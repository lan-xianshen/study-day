package com.lan.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author jianglin.lan
 * @title: MainConfigProfile
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/19 16:57
 */
@Configuration
public class MainConfigProfile {

    public DataSource dataSourceDev () throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser ("root");
        dataSource.setPassword ("root");
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/sys");
        dataSource.setDriverClass ("com.mysql.jdbc.Driver");
        return dataSource;
    }

    public DataSource dataSourceTest () throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser ("root");
        dataSource.setPassword ("root");
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setDriverClass ("com.mysql.jdbc.Driver");
        return dataSource;
    }
    public DataSource dataSourcePro () throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser ("root");
        dataSource.setPassword ("root");
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/world");
        dataSource.setDriverClass ("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
