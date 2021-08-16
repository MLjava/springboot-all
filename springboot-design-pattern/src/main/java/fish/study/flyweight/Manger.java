package fish.study.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class Manger implements Employee {

    private final String department;

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public Manger(String department) {
        this.department = department;
    }

    @Override
    public void report() {
        log.info("department:{},content:{}", department, content);
    }
}
