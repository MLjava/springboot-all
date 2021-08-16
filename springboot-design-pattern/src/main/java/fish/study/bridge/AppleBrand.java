package fish.study.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class AppleBrand implements Brand {

    @Override
    public void doOpen() {
        log.info("苹果手机开机");
    }

    @Override
    public void doClose() {
        log.info("苹果手机开机");
    }

    @Override
    public void doCall() {
        log.info("苹果手机开机");
    }
}
