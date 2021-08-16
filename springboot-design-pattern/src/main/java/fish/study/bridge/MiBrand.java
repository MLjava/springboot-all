package fish.study.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class MiBrand implements Brand {

    @Override
    public void doOpen() {
        log.info("小米手机开机");
    }

    @Override
    public void doClose() {
        log.info("小米手机关机");
    }

    @Override
    public void doCall() {
        log.info("小米手机打电话");
    }
}
