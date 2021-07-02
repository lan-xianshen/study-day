package com.lan.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author jianglin.lan
 * @title: SchoolFactoryBean
 * @projectName study-day
 * @description: TODO
 * @date 2021/6/9 14:31
 */
public class SchoolFactoryBean implements FactoryBean<School> {

    /**
     * 返回一个School(实体)对象，这个对象会添加到容器中
     */
    @Override
    public School getObject () throws Exception {
        return new School ();
    }

    @Override
    public Class<?> getObjectType () {
        return School.class;
    }

    /**
     * @return true:bean是单实例的，在容器中保留一份
     * false:多实例，每次获取都会创建一个新的bean
     */
    @Override
    public boolean isSingleton () {
        return false;
    }
}
