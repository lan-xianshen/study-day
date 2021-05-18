package com.lan.bean;

/**
 * @author jianglin.lan
 * @title: Person
 * @projectName study-day-by-day
 * @description: TODO
 * @date 2021/5/14 10:01
 */
public class Person {
    private String name;
    private Integer age;
    private Integer sex;

    public Person (String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person () {
        super();
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
                ", sex=" + sex +
                '}';
    }
}
