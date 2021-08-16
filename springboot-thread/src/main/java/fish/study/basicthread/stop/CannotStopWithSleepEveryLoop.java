package fish.study.basicthread.stop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: malin
 * @date: 2020/7/26 3:49 下午
 **/
@Slf4j
public class CannotStopWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000) {
                try {
                    if (num % 100 == 0) {
                        log.info("num:{}", num);
                    }
                    localSleep();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num++;
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }

    private static void localSleep() throws InterruptedException {
        Thread.sleep(10);
    }
}
