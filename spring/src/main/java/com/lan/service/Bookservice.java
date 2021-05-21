package com.lan.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author jianglin.lan
 * @title: Bookservice
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1813:51
 */
@Service
public class Bookservice implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization (Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization (Object bean, String beanName) throws BeansException {
        return null;
    }
}
