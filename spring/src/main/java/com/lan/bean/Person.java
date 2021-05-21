package com.lan.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author jianglin.lan
 * @title: Person
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/14 10:01
 */
public class Person {
    //使用@Value赋值
        //1、基本数值
        //2、可以写SpEL: #{}
        //3、可以写${}:取出配置文件中的值（在运行环境变量值）
    @Value("张三")
    private String name;
    private Integer age;
    @Value ("${person.nickName}")
    private String nickName;
    private Integer sex;

    public Person () {
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Integer getAge () {
        return age;
    }

    public void setAge (Integer age) {
        this.age = age;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex () {
        return sex;
    }

    public void setSex (Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                '}';
    }

    public Person (String name, Integer age, String nickName, Integer sex) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
        this.sex = sex;
    }
}
