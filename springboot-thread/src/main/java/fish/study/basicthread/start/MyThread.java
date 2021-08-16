package fish.study.basicthread.start;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: malin
 * @date: 2020/7/26 1:39 下午
 **/
@Slf4j
public class MyThread extends Thread {

    @Override
    public void run() {
        log.info("我是通过Thread");
    }
}
