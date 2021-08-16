package fish.study.basicthread.start;

/**
 * @author: malin
 * @date: 2020/7/26 1:48 下午
 **/
public class Main {

    public static void main(String[] args) {
//        Thread runnner = new Thread(new MyRunner());
//        runnner.start();
//        Thread thread = new MyThread();
//        thread.start();
        Count count = new Count(1);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(count);
            thread.start();
        }
    }
}
