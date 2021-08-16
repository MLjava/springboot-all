package fish.study.factory.simple;

public class Buyer {

    public String getName(String name) {
        Fruit fruit = SimpleFruitFactory.getFruit(name);
        if (fruit != null) {
            return fruit.getName();
        }
        return null;
    }

}
