package com.lan.config;

import com.lan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jianglin.lan
 * @title: MainConfigPropertyValue
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1914:43
 */
//@PropertySource 读取外部配置文件(默认properties，yml需要重新配置)中的k/v保存到运行的环境变量中
@PropertySource (value = {"classpath:/person.properties"},encoding = "UTF-8")
@Configuration
public class MainConfigPropertyValue {

    @Bean("person")
    public Person person(){
        return new Person ();
    }
}
