package factory.abstractFactory;

import factory.bean.ICourse;
import factory.bean.INote;
import factory.bean.IVideos;

/**
 * @author jianglin.lan
 * @title: AbstractFactoryTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:43
 */
public class AbstractFactoryTest {

    public static void main (String[] args) {
        //Java工厂（ 产品族）
        ICourseAbFactory javaFactory = new JavaFactory ();

        // 生产 创建
        ICourse javaCourse = javaFactory.createCourse ();
        INote javaNote = javaFactory.createNote ();
        IVideos javaVideos = javaFactory.createVideos ();

        System.out.println ("--------------");
        // 购买 使用
        javaCourse.record ();
        javaNote.note ();
        javaVideos.videos ();

        System.out.println ("*****************");
        System.out.println ();
        System.out.println ();

        ICourseAbFactory phpFactory = new PHPFactory ();

        ICourse phpCourse = phpFactory.createCourse ();
        INote phpNote = phpFactory.createNote ();
        IVideos phpVideos = phpFactory.createVideos ();
        System.out.println ("--------------");
        phpCourse.record ();
        phpNote.note ();
        phpVideos.videos ();

    }
}
