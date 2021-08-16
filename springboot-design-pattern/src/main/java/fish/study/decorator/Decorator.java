package fish.study.decorator;

/**
 * @author malin
 */
public class Decorator extends Drink {

    protected final Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return 0;
    }
}
