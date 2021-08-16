package fish.study.controller.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserView {

    private Integer age;

    private List<User> users;

}
