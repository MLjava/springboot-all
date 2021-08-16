package fish.study.singleton.lazy;

/**
 * @author malin
 */
public class SingletonLazy {

    private volatile SingletonLazy singletonLazy;

    public SingletonLazy getInstance() {
        if (singletonLazy == null) {
            synchronized (this) {
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

    private SingletonLazy() {
    }

}
