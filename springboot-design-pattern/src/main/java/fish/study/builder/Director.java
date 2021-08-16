package fish.study.builder;

/**
 * @author malin
 */
public class Director {

    private final CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car createCar() {
        carBuilder.createColor();
        carBuilder.createPrice();
        carBuilder.createName();
        return carBuilder.getCar();
    }


}
