package fish.study.factory.simple;

/**
 * @author malin
 */
public class SimpleFruitFactory {

    public static Fruit getFruit(String name) {
        if ("Apple".equalsIgnoreCase(name)) {
            return new Apple();
        }
        if ("Orange".equalsIgnoreCase(name)) {
            return new Oranger();
        }
        return null;
    }

}
