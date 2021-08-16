package fish.study.basicthread.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: malin
 * @date: 2020/8/1 2:50 下午
 **/
@Slf4j
public class CountDownLatchDemo1 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable runnable = () -> {
                try {
                    log.info("线程no正在检查：" + no);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            };
            service.submit(runnable);
        }
        log.info("等待所有人检查完");
        latch.await();
        log.info("所有人都完成");

    }

}
