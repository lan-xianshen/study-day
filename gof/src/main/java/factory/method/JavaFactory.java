package factory.method;

import factory.bean.ICourse;
import factory.bean.JavaCourse;

/**
 * @author jianglin.lan
 * @title: JavaFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 9:55
 */
public class JavaFactory implements ICourseFactory {

    @Override
    public ICourse create () {
        return new JavaCourse();
    }
}
