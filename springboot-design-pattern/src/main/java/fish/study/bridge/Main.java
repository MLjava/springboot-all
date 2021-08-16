package fish.study.bridge;

public class Main {

    public static void main(String[] args) {
        Brand brand = new HuaweiBrand();
        AbstractPhone phone = new FoldPhone(brand);
        phone.open();
        phone.call();
        phone.close();
    }
}
