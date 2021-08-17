package factory.bean;

/**
 * @author jianglin.lan
 * @title: JavaVideos
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:37
 */
public class JavaVideos implements IVideos {
    @Override
    public void videos () {
        System.out.println ("JavaVideos use ......");
    }

    public JavaVideos () {
        System.out.println ("JavaVideos construct ...");
    }
}
