package factory.bean;

/**
 * @author jianglin.lan
 * @title: PHPVideos
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:41
 */
public class PHPVideos implements IVideos {
    @Override
    public void videos () {
        System.out.println ("PHPVideos use ...");
    }

    public PHPVideos () {
        System.out.println ("PHPVideos construct ...");
    }
}
