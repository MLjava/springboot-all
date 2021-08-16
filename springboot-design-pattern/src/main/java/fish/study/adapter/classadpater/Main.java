package fish.study.adapter.classadpater;

public class Main {

    public static void main(String[] args) {
        IBatterLine batterLine = new VoltageAdapter();
        Phone phone = new Phone();
        phone.charming(batterLine);
    }
}
