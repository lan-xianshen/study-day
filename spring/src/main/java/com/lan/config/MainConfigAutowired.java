package com.lan.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author jianglin.lan
 * @title: MainConfigAutowired
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1915:57
 *
 * 自动装配：
 *      Spring利用依赖注入（DI）,完成对IOC容器中各个组件的依赖关系复制
 *
 *  1）、@Autowired：自动注入
 *          1）、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class)
 *          2)、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *                                  applicationContext.getBean（"bean id"）
 *          3)、@Qualifier("bean id") :使用@Qualifier指定需要转配的组件的id,而不是使用属性名称
 *          4）、自动装配默认一定要将属性复制好，没有就会报错
 *                  可以使用@Autowired(required=false)
 *          5)、@Primary:让Spring进行自动装配的时候，默认使用首选的bean；
 *                  也可以使用@Qualifier指定需要装配的bean的名字
 *
 * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330) [java规范]
 *          @Resource：默认按照名称装配的，不支持@Primary 和@Autowired(required=false)
 *          @Inject 需要导入javax。inject的包，和Autowired功能一样 不支持@Autowired(required=false)
 *
 * 3）、@Autowired :适用于 构造器、参数、方法、属性:都是从容器中获取参数组件的值
 *          1）、[标注在方法位置]：@Bean+方法参数：参数从容器中获取；默认不写@Autowired效果是一样的；都能自动
 *          2)、[标注在构造器上]：如果组件只有一个构造器，这个构造器的@Autowired可以省略
 *
 *  4)、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory,***）;
 *          自定义组件实现xxxAware:在创建对象的时候，会调用接口规定的方法注入相关组件：参照Aware
 *          xxxAware:功能是使用xxxProcessor
 */
@Configuration
public class MainConfigAutowired {
}
