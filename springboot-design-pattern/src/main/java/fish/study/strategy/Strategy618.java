package fish.study.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class Strategy618 implements ActivityStrategy {


    @Override
    public void promotion() {
        log.info("618");
    }
}
