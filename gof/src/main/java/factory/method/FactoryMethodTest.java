package factory.method;

import factory.bean.ICourse;

/**
 * @author jianglin.lan
 * @title: FactoryMethodTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:06
 */
public class FactoryMethodTest {
    public static void main (String[] args) {
        ICourseFactory javaFactory = new JavaFactory ();
        ICourse iCourse = javaFactory.create ();
        iCourse.record ();


        ICourseFactory phpFactory = new PHPFactory ();
        ICourse iCourse1 = phpFactory.create ();
        iCourse1.record ();
    }
}
