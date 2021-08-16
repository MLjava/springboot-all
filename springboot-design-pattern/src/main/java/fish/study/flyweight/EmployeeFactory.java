package fish.study.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author malin
 */
public class EmployeeFactory {

    private static final Map<String, Employee> EMPLOYEE_MAP = new ConcurrentHashMap<>();

    private EmployeeFactory() {
    }

    public static void getManger(String department) {
        Employee employee = EMPLOYEE_MAP.get(department);
        Manger manger;
        if (employee != null) {
            manger = (Manger) employee;
        } else {
            employee = new Manger(department);
            EMPLOYEE_MAP.put(department, employee);
            manger = (Manger) employee;
        }
        manger.setContent(department + "开始汇报" + manger);
        manger.report();
    }

}
