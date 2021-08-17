package factory.bean;

/**
 * @author jianglin.lan
 * @title: PHPNote
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:37
 */
public class PHPNote implements INote {
    @Override
    public void note () {
        System.out.println ("PHPNote use ...");
    }

    public PHPNote () {
        System.out.println ("PHPNote construct ...");
    }
}
