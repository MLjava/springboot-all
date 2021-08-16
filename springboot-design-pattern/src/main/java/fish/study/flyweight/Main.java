package fish.study.flyweight;

import java.util.Random;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        String[] department = new String[]{"HA", "PMO", "RA", "TF"};
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            EmployeeFactory.getManger(department[random.nextInt(department.length)]);
        }
    }
}
