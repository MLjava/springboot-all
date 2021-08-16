package fish.study.basicthread.stop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: malin
 * @date: 2020/7/26 3:21 下午
 **/
@Slf4j
public class RightWayStopWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 300) {
                    if (num % 100 == 0) {
                        log.info("num是一百的倍数：{}", num);
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
