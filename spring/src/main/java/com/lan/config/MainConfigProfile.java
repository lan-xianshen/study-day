package com.lan.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author jianglin.lan
 * @title: MainConfigProfile
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/19 16:57
 *  @Profile: 指定组件在哪个环境的情况下才能被注册到容器中，不指定任何环境都能注册到容器中
 *      1)、加了环境标识的bean,只有这个环境被激活才能注册到容器中
 *
 *      环境选择：
 *      1）、使用命令行参数更改环境：-Dspring.profiles.active=test
 *      2）、使用代码的方式 --见TesIOCTestProfile
 *
 *
 *
 */
@Configuration
@PropertySource("classpath:/dbconfig.properties")
public class MainConfigProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String driverClass;

    private StringValueResolver valueResolver;

    @Profile ("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev (@Value("${db.passWord}") String passWord) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser (user);
        dataSource.setPassword (passWord);
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/sys");
        dataSource.setDriverClass (driverClass);
        return dataSource;
    }

    @Profile ("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest (@Value("${db.passWord}") String passWord) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser (user);
        dataSource.setPassword (passWord);
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setDriverClass (driverClass);
        return dataSource;
    }
    @Profile ("pro")
    @Bean("proDataSource")
    public DataSource dataSourcePro (@Value("${db.passWord}") String passWord) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource ();
        dataSource.setUser (user);
        dataSource.setPassword (passWord);
        String value = valueResolver.resolveStringValue ("${db.driverClass}");
        dataSource.setJdbcUrl ("jdbc:mysql://127.0.0.1:3306/world");
        dataSource.setDriverClass (driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver (StringValueResolver resolver) {
        this.valueResolver = resolver;
        driverClass = valueResolver.resolveStringValue ("${db.driverClass}");

    }
}
