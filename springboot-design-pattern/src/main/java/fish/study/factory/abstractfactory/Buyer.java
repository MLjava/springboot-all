package fish.study.factory.abstractfactory;

public class Buyer {

    private final AbstractFruitFactory abstractFruitFactory;

    public Buyer(AbstractFruitFactory abstractFruitFactory) {
        this.abstractFruitFactory = abstractFruitFactory;
    }

    public Fruit name(String name) {
        return abstractFruitFactory.createFruit(name);
    }
}
