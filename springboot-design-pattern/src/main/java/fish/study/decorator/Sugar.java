package fish.study.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class Sugar extends Decorator {

    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return drink.cost() + 3.00D;
    }
}
