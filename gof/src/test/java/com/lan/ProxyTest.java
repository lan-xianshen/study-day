package com.lan;

import proxy.ITeacherDao;
import proxy.ProxyFactory;
import proxy.TeacherDao;

/**
 * @author jianglin.lan
 * @title: ProxyTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/6/24 13:21
 */
public class ProxyTest {
    public static void main (String[] args) {
        ITeacherDao teacherDao = new TeacherDao ();

        ITeacherDao teacherDao1 = (ITeacherDao)new ProxyFactory (teacherDao).getProxyInstance ();
        //ITeacherDao teacherDao1 = (ITeacherDao)proxyFactory.getProxyInstance ();

        System.out.println (teacherDao1.getClass ());

        teacherDao1.match (10, 5);
    }
}
