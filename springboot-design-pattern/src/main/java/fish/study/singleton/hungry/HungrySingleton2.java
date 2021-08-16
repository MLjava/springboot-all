package fish.study.singleton.hungry;

/**
 * @author malin
 */
public class HungrySingleton2 {

    private static final HungrySingleton2 HUNGRY_SINGLETON_2;

    private HungrySingleton2() {
    }

    static {
        HUNGRY_SINGLETON_2 = new HungrySingleton2();
    }

    public static HungrySingleton2 getInstance() {
        return HUNGRY_SINGLETON_2;
    }

}
