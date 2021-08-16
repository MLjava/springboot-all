package fish.study.adapter.classadpater;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class Phone {

    public void charming(IBatterLine batterLine) {
        int output = batterLine.output();
        if (output == 5) {
            log.info("可以充电");
            return;
        }
        log.info("无法充电");
    }

}
