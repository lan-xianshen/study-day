package com.lan.config;

import com.lan.bean.Person;
import com.lan.bean.Student;
import com.lan.condition.LinuxCondition;
import com.lan.condition.MyImportBeanDefineRegister;
import com.lan.condition.MyImportSelector;
import com.lan.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author jianglin.lan
 * @title: MainConfigTwo
 * @projectName study-day-by-day
 * @description: TODO
 * @date 2021/5/18 14:29
 */
@Configuration
@Conditional (value = {WindowsCondition.class})
@Import (value = {Student.class, MyImportSelector.class, MyImportBeanDefineRegister.class})
public class MainConfigTwo {

    /**
     * Specifies the name of the scope to use for the annotated component/bean.
     * <p>Defaults to an empty string ({@code ""}) which implies
     * { ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
     * @since 4.2
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     *  org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     *  org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * prototype:多实例的
     * singleton：单实例的（默认）  :ioc容器启动会调用方法创建对象放到ioc容器中
     *              以后每次获取就是从容器中（map.get()）获取
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     */

    @Scope(value = "prototype")
    @Bean(value = "person")
    public Person person(){
        return  new Person ();
    }

    @Bean("bill")
    public Person person01(){
        return  new Person ("bill",55,1);
    }


    @Bean("linus")
    @Conditional (value = {LinuxCondition.class})
    public Person person02(){
        return  new Person ("linus",66,1);
    }

    /**
     * 给容器中注册组件
     *  1、扫描包+组件标注注解（@Controller/@Service/@Component）
     *  2、@Bean[导入的第三方包里面的组件]
     *  3、@Import[快速的给容器中导入一个组件]
     *     1)、@Import(要导入的组件)，容器中就会自动注册组件，id为全类名
     *     2）、实现ImportSelector接口，返回需要导入的bean数组
     *     3）、ImportBeanDefinitionRegistrar：手动注册到容器中
     *
     */
}
