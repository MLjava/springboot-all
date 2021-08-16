package fish.study.builder;

/**
 * @author malin
 */
public abstract class CarBuilder {

    private final Car car;

    public CarBuilder() {
        car = new Car();
    }

    public abstract void createColor();

    public abstract void createPrice();

    public abstract void createName();

    public Car getCar() {
        return car;
    }
}
