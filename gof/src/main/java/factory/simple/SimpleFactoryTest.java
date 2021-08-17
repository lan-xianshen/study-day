package factory.simple;

import factory.bean.ICourse;
import factory.bean.JavaCourse;

/**
 * @author jianglin.lan
 * @title: SimpleFactoryTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 9:28
 */
public class SimpleFactoryTest {
    public static void main (String[] args) {
        CourseFactory courseFactory = new CourseFactory ();
        ICourse iCourse = courseFactory.create (JavaCourse.class);
        iCourse.record ();

    }
}
