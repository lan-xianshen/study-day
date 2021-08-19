package singleton;

/**
 * @author lan
 * @create 2021-08-18 12:54
 */
public class LazyCheckSingleton {
    private volatile static LazyCheckSingleton simpleSingleTon= null;
    private LazyCheckSingleton(){

    }

    public static LazyCheckSingleton getInstance(){
        if (null == simpleSingleTon){
            synchronized (LazyCheckSingleton.class){
                if(null == simpleSingleTon){
                    simpleSingleTon = new LazyCheckSingleton();
                }
            }
        }
        return simpleSingleTon;
    }
}
