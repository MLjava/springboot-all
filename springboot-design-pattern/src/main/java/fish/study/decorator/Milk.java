package fish.study.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        log.info(drink.getName() + "加了牛奶");
    }

    @Override
    public double cost() {
        log.info("美式咖啡原价：{}", drink.cost());
        log.info("牛奶价格：{}", 2.00);
        return drink.cost() + 2.00D;
    }
}
