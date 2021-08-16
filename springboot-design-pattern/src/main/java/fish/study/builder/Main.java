package fish.study.builder;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        CarBuilder carBuilder = new CommonCarBuilder();
        Director director = new Director(carBuilder);
        Car car = director.createCar();
        System.out.println(car);
    }
}
