package com.lan.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author jianglin.lan
 * @title: MyBeanFactoryPostProcessor
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/9 16:56
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory (ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println ("MyBeanFactoryPostProcessor....");
        int count = beanFactory.getBeanDefinitionCount ();
        String[] names = beanFactory.getBeanDefinitionNames ();
        System.out.println ("当前myBean中有"+count+"个bean");
        System.out.println (Arrays.asList (names));
    }
}
