package fish.study.factory.abstractfactory;

/**
 * @author malin
 */
public abstract class AbstractFruitFactory {

    public abstract Fruit createFruit(String fruitName);

    protected Fruit produceFruit(String fruitName) {
        switch (fruitName) {
            case "Apple": {
                Apple apple = new Apple();
                apple.setName("苹果");
                return apple;
            }
            case "Orange": {
                Orange orange = new Orange();
                orange.setName("橙子");
                return orange;
            }
            case "Pear" : {
                Pear pear = new Pear();
                pear.setName("梨子");
                return pear;
            }
            default: {
                return null;
            }
        }
    }
}
