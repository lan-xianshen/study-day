package com.lan.config;

import com.lan.bean.Life;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jianglin.lan
 * @title: MainConfigLife
 * @projectName study-day
 * @description: TODO bean生命周期
 * @date 2021/5/19 10:30
 *
 * bean创建----初始化----销毁过程
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建
 *      多实例：在每次获取的时候创建
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 *
 *初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 *
 * BeanPostProcessor.postProcessAfterInitialization
 *
 *销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean;容器不会调用销毁
 *
 *
 *
 * 遍历得到容器中所有的BeanPostProcessor，挨个执行beforeInitialization,一旦返回null
 * ,跳出循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 *
 *	populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 *{
 *    applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *   invokeInitMethods(beanName, wrappedBean, mbd);执行初始化方法
 *   applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *}
 *
 *  1)、指定初始化和销毁方法：
 *      通过@Bean指定 init-method和destory-method
 *  2）通过让Bean实现 InitializingBean(定义初始化逻辑)
 *                  DisposableBean(定义销毁逻辑)
 *  3)、可以使用JSR250:
 *          @PostConstruct:在bean创建完成并且完成属性赋值完成，来执行初始化方法
 *          @PreDestroy：在容器销毁bean之前通知进行清理工作
 *  4)、BeanPostProcessor[interface],bean的后置处理器，在bean初始化前后进行一些处理工作
 *        postProcessBeforeInitialization：在初始化之前
 *        postProcessAfterInitialization：在销毁之后
 *
 *  Spring底层对BeanPostProcessor 的使用
 *          bean赋值,注入其它组件，@Autowired,生命周期注解功能,@Async,xxx BeanPostProcessor
 */
@Configuration
@ComponentScan(value = {"com.lan.bean"})
public class MainConfigLife {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Life life () {
        return new Life ();
    }
}
