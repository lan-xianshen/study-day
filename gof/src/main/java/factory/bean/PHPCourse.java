package factory.bean;

/**
 * @author jianglin.lan
 * @title: PHPCourse
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 9:59
 */
public class PHPCourse implements ICourse{
    @Override
    public void record () {
        System.out.println ("PHP use ...");
    }

    public PHPCourse () {
        System.out.println ("PHPCourse construct ...");
    }
}
