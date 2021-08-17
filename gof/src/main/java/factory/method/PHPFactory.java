package factory.method;

import factory.bean.ICourse;
import factory.bean.PHPCourse;

/**
 * @author jianglin.lan
 * @title: PHPFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:04
 */
public class PHPFactory implements ICourseFactory {
    @Override
    public ICourse create () {
        return new PHPCourse ();
    }
}
