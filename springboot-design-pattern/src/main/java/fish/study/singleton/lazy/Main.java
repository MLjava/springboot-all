package fish.study.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        Singleton singleton = Singleton.SINGLETON;
        Class<? extends Singleton> clz = singleton.getClass();
        Constructor<?> declaredConstructor;
        try {
            declaredConstructor = clz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            try {
                Object o = declaredConstructor.newInstance();
                System.out.println(o);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
