package fish.study.singleton.hungry;

/**
 * @author malin
 */
public class HungrySingleton {

    private static final HungrySingleton HUNGRYSINGLETON = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return HUNGRYSINGLETON;
    }

}
