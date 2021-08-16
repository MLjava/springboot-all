package fish.study.basicthread.stop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: malin
 * @date: 2020/7/26 3:08 下午
 **/
@Slf4j
public class RightWayStopThreadWithoutSleep {

    @SneakyThrows
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
              if (num % 10000 == 0) {
                  log.info("nums是10000的倍数:{}", num);
              }
              num ++;
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        // 线程中断
        Thread.sleep(1500);
        thread.interrupt();
    }
}
