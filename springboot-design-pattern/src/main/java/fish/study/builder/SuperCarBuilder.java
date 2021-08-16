package fish.study.builder;

import java.math.BigDecimal;

/**
 * @author malin
 */
public class SuperCarBuilder extends CarBuilder {

    @Override
    public void createColor() {
        getCar().setColor("红色");
    }

    @Override
    public void createPrice() {
        getCar().setPrice(new BigDecimal("50"));
    }

    @Override
    public void createName() {
        getCar().setName("超级跑车");
    }
}
