package fish.study.decorator;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        Drink drink = new Americano();
        Decorator milk = new Milk(drink);
        Decorator sugar = new Sugar(milk);
        double cost = sugar.cost();
        System.out.println(cost);
    }
}
