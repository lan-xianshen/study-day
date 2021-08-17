package factory.abstractFactory;

import factory.bean.*;

/**
 * @author jianglin.lan
 * @title: JavaFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:35
 */
public class JavaFactory implements ICourseAbFactory {
    @Override
    public ICourse createCourse () {
        return new JavaCourse ();
    }

    @Override
    public INote createNote () {
        return new JavaNote ();
    }

    @Override
    public IVideos createVideos () {
        return new JavaVideos ();
    }
}
