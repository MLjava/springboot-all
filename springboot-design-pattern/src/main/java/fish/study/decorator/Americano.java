package fish.study.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class Americano extends Coffee {

    public Americano() {
        setName("美式咖啡");
    }

    @Override
    public double cost() {
        return 5.00D;
    }
}
