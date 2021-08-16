package fish.study.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class HuaweiBrand implements Brand {


    @Override
    public void doOpen() {
        log.info("华为手机开机");
    }

    @Override
    public void doClose() {
        log.info("华为手机开机");
    }

    @Override
    public void doCall() {
        log.info("华为手机开机");
    }
}

