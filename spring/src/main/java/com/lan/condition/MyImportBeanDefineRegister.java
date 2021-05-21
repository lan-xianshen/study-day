package com.lan.condition;

import com.lan.bean.School;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author jianglin.lan
 * @title: MyImportBeanDefineRegister
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/18 18:11
 */
public class MyImportBeanDefineRegister implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata 当前类的注解信息
     *                               BeanDefinitionRegistry  ：BeanDefinition注册类；
     *                               把所有需要添加到容器中的bean,调用BeanDefinitionRegistry.registerBeanDefinition手动注册进来
     */
    @Override
    public void registerBeanDefinitions (AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b = registry.containsBeanDefinition ("com.lan.bean.Student");
        boolean b1 = registry.containsBeanDefinition ("person");
        if (b&b1) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition (School.class);
            //注册一个bean，指定名称
            registry.registerBeanDefinition ("school", rootBeanDefinition);
        }
    }
}
