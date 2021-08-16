package fish.study.basicthread.call;

import java.util.concurrent.*;

/**
 * @author: malin
 * @date: 2020/8/2 2:32 下午
 **/
public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
//        MyCallable callable = new MyCallable();
//        Future<String> future = service.submit(callable);
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        service.shutdown();
        // lambada
        Callable<String> callable = () -> {
            Thread.sleep(3000);
            return "Hello world!";
        };
        Future<String> future = service.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
