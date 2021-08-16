package fish.study.basicthread.volidate;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

/**
 * @author: malin
 * @date: 2020/7/26 4:21 下午
 **/
@Slf4j
public class Consumer {

    @Setter
    private BlockingQueue<Integer> blockingQueue;

    public void consumer() {
    }

}
