package fish.study.basicthread.start;

/**
 * @author: malin
 * @date: 2020/8/1 3:49 下午
 **/
public class Count implements Runnable {

   private int a;

   public Count(int a) {
       this.a = a;
   }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            a ++;
            System.out.println("a:" + a);
        }
    }
}
