package fish.study.factory.abstractfactory;

/**
 * @author malin
 */
public class ShanghaiFruitFactory extends AbstractFruitFactory {

    @Override
    public Fruit createFruit(String fruitName) {
        Fruit fruit = produceFruit(fruitName);
        if (fruit != null) {
            fruit.setPlace("上海");
            return fruit;
        }
        return null;
    }
}
