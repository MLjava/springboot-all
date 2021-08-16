package fish.study.decorator;

/**
 * @author malin
 */
public class Espresso extends Coffee {

    public Espresso() {
        setName("意大利咖啡");
    }

    @Override
    public double cost() {
        return 7.00D;
    }
}
