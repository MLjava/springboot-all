package fish.study.basicthread.volidate;

import lombok.Setter;

import java.util.concurrent.BlockingQueue;

/**
 * @author: malin
 * @date: 2020/7/26 4:17 下午
 **/
public class Producer implements Runnable {

    @Setter
    private BlockingQueue<Integer> blockingQueue;

    @Setter
    private volatile boolean flag = true;

    @Override
    public void run() {
        int num = 0;
        while (flag && num <= 10000) {
            if (num % 100 == 0) {
                // 添加数字
                blockingQueue.add(num);
            }
            num++;
        }
    }
}
