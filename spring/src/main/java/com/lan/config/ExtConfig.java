package com.lan.config;

import com.lan.bean.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jianglin.lan
 * @title: ExtConfig
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/8 13:47
 * <p>
 * 拓展原理：
 * BeanPostProcessor : bean后置处理器，bean创建对象初始化前后进行拦截工作的
 *1、BeanFactoryPostProcessor:beanFactory 后置处理器
 *          在 beanFactory 标准初始化之后调用，所有的 bean定义已经保存加载到 beanFactory ，但是bean的实例还没有创建
 *
 *      1.1、ioc容器创建对象
 *      1.2、invokeBeanFactoryPostProcessors(beanFactory); 执行 BeanFactoryPostProcessors
 *           如何找到所有的 BeanFactoryPostProcessor并执行他们的方法
 *           1.2.1、直接在 beanFactory 中找到所有类型是  BeanFactoryPostProcessor 的组件，并执行他们的方法
 *           1.2.2、在初始化创建其它组件之前执行
 *2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry()
 *      在所有的bean定义信息将要被加载，bean实例还未创建
 *
 *      优先于 BeanFactoryPostProcessor 执行
 *      利用 BeanDefinitionRegistryPostProcessor 给容器中再额外添加一些组件
 *
 *      2.1、ioc创建对象
 *      2.2、refresh()->invokeBeanFactoryPostProcessors(beanFactory)
 *      2.3、从日其中获取到所有 BeanDefinitionRegistryPostProcessor 组件，
 *          1）、依次触发所有的 postProcessBeanDefinitionRegistry() 方法
 *          2）、再来触发 postProcessBeanFactory() 方法
 *      2.4、再来从容器中找到 BeanDefinitionRegistryPostProcessor 组件，然后依次触发postProcessBeanFactory（）方法
 *
 */
@ComponentScan("com.lan.ext")
@Configuration
public class ExtConfig {
    @Bean
    public School school () {
        return new School ();
    }
}
