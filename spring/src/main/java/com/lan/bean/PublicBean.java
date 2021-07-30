package com.lan.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: PublicBean
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/29 10:37
 */
@Component
public class PublicBean {

    public String name = "aaaaaaaa";

    @Value("publicBean-sex")
    private String sex;


    public static PublicBean publicBean;


    public PublicBean () {
        publicBean = this;
    }

    public  String getDemo () {
        System.out.println ("getDemo=" + PublicBean.publicBean.sex);
        return PublicBean.publicBean.sex;
    }
}
