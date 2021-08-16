package fish.study.proxy.interfaceproxy;

/**
 * @author malin
 */
public class RealCall implements Call {

    @Override
    public void call() {
        System.out.println("Real Call");
    }
}
