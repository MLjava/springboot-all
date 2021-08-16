package fish.study.basicthread.countdownlatch;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: malin
 * @date: 2020/8/1 3:03 下午
 **/
@Slf4j
public class CountDownLatchDemo2 {

    @SneakyThrows
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = 1 + i;
            Runnable runnable = () -> {
                log.info("线程no:{}正在等待裁判发令" , no);
                try {
                    begin.await();
                    log.info("线程no:{}开始跑步", no);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            service.submit(runnable);
        }
        Thread.sleep(Long.parseLong("5000"));
        log.info("检查");
        begin.countDown();
        log.info("开始比赛");
    }

}
