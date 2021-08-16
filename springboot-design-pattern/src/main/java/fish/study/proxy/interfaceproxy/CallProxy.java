package fish.study.proxy.interfaceproxy;

/**
 * @author malin
 */
public class CallProxy implements Call {

    private final Call call;

    public CallProxy(Call call) {
        this.call = call;
    }

    @Override
    public void call() {
        before();
        call.call();
    }

    private void before() {
        System.out.println("Proxy");
    }

}
