package fish.study.singleton.hungry;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        HungrySingleton3 instance = HungrySingleton3.getInstance();
        HungrySingleton3 instance2 = HungrySingleton3.getInstance();
        System.out.println(instance.toString());
        System.out.println(instance2);
//        Class<HungrySingleton3> clz = HungrySingleton3.class;
//        Constructor<?> declaredConstructor = clz.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        try {
//            Object o = declaredConstructor.newInstance();
//            Object o2 = declaredConstructor.newInstance();
//            Object o3 = declaredConstructor.newInstance();
//            System.out.println(o);
//            System.out.println(o2);
//            System.out.println(o3);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }

}
