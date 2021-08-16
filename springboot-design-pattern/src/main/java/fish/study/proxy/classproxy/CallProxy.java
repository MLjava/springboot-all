package fish.study.proxy.classproxy;

/**
 * @author malin
 */
public class CallProxy {

    private final Call call = new Call();

    public void call() {
        System.out.println("Proxy");
        call.call();
    }

}
