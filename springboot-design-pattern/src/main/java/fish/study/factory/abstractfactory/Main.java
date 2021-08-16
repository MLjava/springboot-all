package fish.study.factory.abstractfactory;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        AbstractFruitFactory abstractFruitFactory = new ShanghaiFruitFactory();
        Buyer buyer = new Buyer(abstractFruitFactory);
        Fruit fruit = buyer.name("Pear");
        System.out.println(fruit);
    }
}
