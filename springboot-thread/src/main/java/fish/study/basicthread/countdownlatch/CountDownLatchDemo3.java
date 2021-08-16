package fish.study.basicthread.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: malin
 * @date: 2020/8/1 3:13 下午
 **/
@Slf4j
public class CountDownLatchDemo3 {

    public static void main(String[] args) throws InterruptedException {
        log.info("裁判开始检查场地。。。。");
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable task = () -> {
              log.info("运动员no:{}等待裁判发令", no);
                try {
                    start.await();
                    Thread.sleep((long) (Math.random() * 10000));
                    log.info("运动员no:{}跑道终点", no);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    end.countDown();
                }
            };
            service.submit(task);
        }
        Thread.sleep(5000);
        start.countDown();
        log.info("开始比赛。。。。");
        end.await();
        log.info("比赛结束，所有运动员都来到终点");
    }
}
