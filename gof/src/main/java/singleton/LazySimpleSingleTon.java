package singleton;

/**
 * @author lan
 * @create 2021-08-18 11:58
 */
public class LazySimpleSingleTon {
    private static LazySimpleSingleTon lazySimpleSingleTon = null;

    private LazySimpleSingleTon(){}

    public static LazySimpleSingleTon getInstance(){
        if(null == lazySimpleSingleTon){
            lazySimpleSingleTon = new LazySimpleSingleTon();
        }
        return  lazySimpleSingleTon;
    }
}
