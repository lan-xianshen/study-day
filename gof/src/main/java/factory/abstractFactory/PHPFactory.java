package factory.abstractFactory;

import factory.bean.*;

/**
 * @author jianglin.lan
 * @title: PHPFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:42
 */
public class PHPFactory implements ICourseAbFactory {
    @Override
    public ICourse createCourse () {
        return new PHPCourse ();
    }

    @Override
    public INote createNote () {
        return new PHPNote ();
    }

    @Override
    public IVideos createVideos () {
        return new PHPVideos ();
    }
}
