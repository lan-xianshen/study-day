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
 * <p>
 * 环境搭建：
 * 1、导入相关依赖
 * 数据源、数据库驱动、Spring-jdbc模块
 * 2、配置数据源、JdbcTemplate(Spring提供的简化数据库操作的工具)操作数据
 * 3、给目标方法标注 @Transactional 表示当前方法是一个事务方法
 * 4、@EnableTransactionManagement 开启基于注解的事务功能
 * 5、配置事务管理器来控制事务：
 *      @Bean
 *      public PlatformTransactionManager transactionManager()
 *
 * 原理：
 * 1、@EnableTransactionManagement
 *      利用 TransactionManagementConfigurationSelector 给容器中导入组件：
 *          AutoProxyRegistrar
 *          ProxyTransactionManagementConfiguration
 * 2、AutoProxyRegistrar：
 *      给容器中注册一个 InfrastructureAdvisorAutoProxyCreator 组件：
 *      InfrastructureAdvisorAutoProxyCreator 利用后置处理器机制在对象创建以后，包装对象，返回
 *      一个代理对象（增强器），代理对象利用拦截器链进行调用
 * 3、ProxyTransactionManagementConfiguration
 *      3.1、给容器中注册事务增强器
 *          3.1.1、事务增强器要用注解的信息 AnnotationTransactionAttributeSource 解析事务注解
 *          3.1.2、事务拦截器 ：
 *              TransactionInterceptor 保存了事务属性信息、事务管理器
 *              他是一个 MethodInterceptor 在目标方法执行的时候
 *                  执行拦截器链：事务拦截器
 *                   1）、先获取事务相关的属性
 *                   2）、再获取 PlatformTransactionManager 如果事先没有添加指定任务 transactionManager，
 *                        最终会从容器中获取一个 PlatformTransactionManager
 *                   3）、执行目标方法
 *                          如果异常、获取到事务管理器，利用事务管理器回滚操作
 *                           如果正常，利用事务管理器提交事务
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
        dataSource.setDriverClass ("com.mysql.cj.jdbc.Driver");

        dataSource.setJdbcUrl ("jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=UTC ");
        /* dataSource.setJdbcUrl ("jdbc:mysql://47.105.46
        .3:3306/oclorderdatebase?useUnicode=true&characterEncoding=utf8&autoReconnect=true");
         */
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
