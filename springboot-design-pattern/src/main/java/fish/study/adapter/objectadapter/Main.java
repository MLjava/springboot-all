package fish.study.adapter.objectadapter;

public class Main {

    public static void main(String[] args) {
        IBatterLine batterLine = new VoltageAdapter(new Voltage());
        Phone phone = new Phone();
        phone.charming(batterLine);
    }
}
