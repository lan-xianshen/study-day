package com.lan.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: MyBeanPostProcessor
 * @projectName study-day
 * @description: TODO 后置处理器
 * @date 2021/5/1913:09
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * bean 初始化之前调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization (Object bean, String beanName) throws BeansException {
        System.out.println ("postProcessBeforeInitialization。。。。。。。" + bean + "***beanName" + beanName);
        return bean;
    }

    /**
     * bean 初始化之后 调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization (Object bean, String beanName) throws BeansException {
        System.out.println ("postProcessAfterInitialization=======:" + bean + "***beanName" + beanName);

        return bean;
    }
}
