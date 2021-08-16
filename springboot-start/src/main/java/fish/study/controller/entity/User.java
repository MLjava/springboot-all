package fish.study.controller.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String name;
    private Integer age;
    private Double score;
}
