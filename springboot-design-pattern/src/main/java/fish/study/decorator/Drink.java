package fish.study.decorator;

/**
 * @author malin
 */
public abstract class Drink {

    private String name;

    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public abstract double cost();
}
