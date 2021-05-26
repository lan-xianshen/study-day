package com.lan.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author jianglin.lan
 * @title: LinuxCondition
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1815:45
 *
 * -Dos.name=linux
 */
public class LinuxCondition implements Condition {
    /**
     * @param context  判断条件能使用的上下文环境
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches (ConditionContext context, AnnotatedTypeMetadata metadata) {
        //
        //1、获取ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory ();
       // System.out.println ("LinuxCondition==>" + beanFactory);
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader ();
       // System.out.println ("LinuxCondition==>" + classLoader);
        //3、获取当前环境信息
        Environment environment = context.getEnvironment ();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry ();
      //  System.out.println ("LinuxCondition==>" + registry);

        String property = environment.getProperty ("os.name");
        return property.contains ("Linux");
    }
}
