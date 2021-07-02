package proxy;

/**
 * @author jianglin.lan
 * @title: TeacherDao
 * @projectName study-day
 * @description: TODO
 * @date 2021/6/24 11:23
 */
public class TeacherDao implements ITeacherDao{

    @Override
    public void teach () {
        System.out.println ("教学开始");
    }

    @Override
    public int match (int i, int j) {
        System.out.println ("数学运算");
        return i+j;
    }
}
