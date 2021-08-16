package fish.study.basicthread.call;

import java.util.concurrent.Callable;

/**
 * @author: malin
 * @date: 2020/8/2 2:52 下午
 **/
public class MyCallable2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "Hello world!!!";
    }
}
