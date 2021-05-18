package com.lan.config;

import com.lan.bean.Person;
import com.lan.service.Bookservice;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author jianglin.lan
 * @title: BeanConfig
 * @projectName study-day-by-day
 * @description: TODO
 * @date 2021/5/17 17:31
 */
@Configuration
@ComponentScan(value = "com.lan", includeFilters = {
       /* @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {Controller.class}
        )
        ,@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {Bookservice.class}
        ),*/
        @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {MyTypeFilter.class}
        )
}, useDefaultFilters = false)
// @ComponentScan value 指定要扫描的包
// excludeFilters = Filter[] :指定扫描的时候按照规则排除哪些组件
// includeFilters = Filter[] :指定扫描的时候按照规则包含哪些组件
// useDefaultFilters 使用指定规则
// FilterType.ANNOTATION 按照注解给定过滤规则
// FilterType.ASSIGNABLE_TYPE 按照给定类型过滤
// FilterType.ASPECTJ 按照aspectj过滤
// FilterType.CUSTOM 按照自定义规则过滤


public class MainConfig {

    @Bean("person")
    public Person getPerson () {
        return new Person ("zhangsan", 22, 1);
    }
}
