package factory.simple;

import factory.bean.ICourse;

/**
 * @author jianglin.lan
 * @title: CourseFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 9:29
 */
public class CourseFactory {

    public ICourse create (Class c) {
        if (null == c) {
            return null;
        }
        ICourse course;

        try {

            course = (ICourse) c.newInstance ();
            return course;
        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        }

        return null;

    }
}
