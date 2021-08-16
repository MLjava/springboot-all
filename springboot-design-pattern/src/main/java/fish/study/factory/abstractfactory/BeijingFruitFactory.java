package fish.study.factory.abstractfactory;

/**
 * @author malin
 */
public class BeijingFruitFactory extends AbstractFruitFactory {

    @Override
    public Fruit createFruit(String fruitName) {
        Fruit fruit = produceFruit(fruitName);
        if (fruit != null) {
            fruit.setPlace("北京");
            return fruit;
        }
        return null;
    }
}
