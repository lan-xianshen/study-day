package factory.bean;

/**
 * @author jianglin.lan
 * @title: JavaNote
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 10:36
 */
public class JavaNote implements INote {
    @Override
    public void note () {
        System.out.println ("JavaNote use ...");
    }

    public JavaNote () {
        System.out.println ("JavaNote construct ...");
    }
}
