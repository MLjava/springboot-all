package fish.study.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class NullStrategy implements ActivityStrategy {

    @Override
    public void promotion() {
        log.info("null");
    }
}
