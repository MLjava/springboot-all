package fish.study.decorator;

/**
 * @author malin
 */
public class Civet extends Coffee {

    public Civet() {
        setName("猫屎咖啡");
    }

    @Override
    public double cost() {
        return 100.20D;
    }
}
