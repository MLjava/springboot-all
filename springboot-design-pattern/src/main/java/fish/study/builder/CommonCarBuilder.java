package fish.study.builder;

import java.math.BigDecimal;

/**
 * @author malin
 */
public class CommonCarBuilder extends CarBuilder {

    @Override
    public void createColor() {
        getCar().setColor("蓝色");
    }

    @Override
    public void createPrice() {
        getCar().setPrice(new BigDecimal("20"));
    }

    @Override
    public void createName() {
        getCar().setName("普通车");
    }
}
