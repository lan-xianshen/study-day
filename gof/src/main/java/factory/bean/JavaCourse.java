package factory.bean;

/**
 * @author jianglin.lan
 * @title: JavaCourse
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/17 9:27
 */
public class JavaCourse implements ICourse {

    @Override
    public void record () {
        System.out.println ("JavaCourse use ...");
    }

    private String name;
    private int age;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public JavaCourse (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public JavaCourse () {
        System.out.println ("JavaCourse construct ...");
    }
}
