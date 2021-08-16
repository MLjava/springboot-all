package fish.study.builder;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author malin
 * 要生产的产品
 */
@Data
public class Car {

    private String name;

    private String color;

    private BigDecimal price;

}
