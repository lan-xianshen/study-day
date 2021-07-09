package com.lan.ext;

import com.lan.bean.Life01;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: MyBeanDefinitionRegistryPostProcessor
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/9 17:30
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * BeanDefinitionRegistry Bean定义中心的保存，以后BeanFactory就是按照 BeanDefinitionRegistry 里面保存的每一个bean定义信息创建bean实例
     */
    @Override
    public void postProcessBeanDefinitionRegistry (BeanDefinitionRegistry registry) throws BeansException {
        System.out.println ("postProcessBeanDefinitionRegistry..bean的数量" + registry.getBeanDefinitionCount ());
        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.rootBeanDefinition (Life01.class).getBeanDefinition ();
        registry.registerBeanDefinition ("myBean",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory (ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println ("postProcessBeanFactory....bean的数量" + beanFactory.getBeanDefinitionCount ());

    }
}
