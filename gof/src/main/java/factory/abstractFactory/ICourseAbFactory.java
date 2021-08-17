package factory.abstractFactory;

import factory.bean.ICourse;
import factory.bean.INote;
import factory.bean.IVideos;

/**
 * @author jianglin.lan
 * @title: ICourseAbFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:32
 */
public interface ICourseAbFactory {
    ICourse createCourse();
    INote createNote();
    IVideos createVideos();
}
