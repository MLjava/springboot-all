package fish.study.singleton.hungry;

/**
 * @author malin
 */
public class HungrySingleton3 {

    private static class HungrySingletonHolder {
        private static final HungrySingleton3 HUNGRY_SINGLETON_3 = new HungrySingleton3();
    }

    public static HungrySingleton3 getInstance() {
        return HungrySingletonHolder.HUNGRY_SINGLETON_3;
    }

    private HungrySingleton3() {
        if (HungrySingletonHolder.HUNGRY_SINGLETON_3 != null) {
            throw new IllegalStateException();
        }
    }

}
