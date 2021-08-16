package fish.study.proxy.interfaceproxy;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        Call call = new CallProxy(new RealCall());
        call.call();
    }
}
