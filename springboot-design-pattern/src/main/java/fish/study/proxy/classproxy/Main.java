package fish.study.proxy.classproxy;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        CallProxy callProxy = new CallProxy();
        callProxy.call();
    }

}
