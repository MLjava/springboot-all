package fish.study.factory.simple;

public class Main {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        String apple = buyer.getName("Orange");
        System.out.println(apple);
    }

}
