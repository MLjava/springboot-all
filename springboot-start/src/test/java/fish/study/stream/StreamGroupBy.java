package fish.study.stream;

import fish.study.SpringBootStartApplicationTests;
import fish.study.controller.entity.User;
import fish.study.controller.entity.UserView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamGroupBy extends SpringBootStartApplicationTests {

    public static List<User> userList() {
        List<User> list = new ArrayList<>();
        list.add(User.builder().name("张").age(12).score(92.2D).build());
        list.add(User.builder().name("李四").age(13).score(85.2D).build());
        list.add(User.builder().name("王五").age(15).score(56.2D).build());
        list.add(User.builder().name("马六六十").age(12).score(78.32D).build());
        list.add(User.builder().name("李七四").age(11).score(66.4D).build());
        list.add(User.builder().name("赵十三").age(11).score(99.2D).build());
        return list;
    }

    /**
     * 测试分组数据转换
     */
    @Test
    public void testGroupBy() {
        List<UserView> userViews = new ArrayList<>(
                userList().stream()
                        .collect(
                                // 根据年龄进行分组
                                Collectors.groupingBy(User::getAge,
                                        // 分组之后进行转换
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                // 数据转换
                                                users -> {
                                                    UserView userView = new UserView();
                                                    userView.setAge(users.stream().findAny().orElse(User.builder().age(0).build()).getAge());
                                                    userView.setUsers(users);
                                                    return userView;
                                                }
                                        ))
                        ).values());
        // 数据进行排序
        userViews.forEach(userView -> userView.getUsers().sort(
                Comparator.comparing(User::getScore).reversed())
        );
        System.out.println(userViews);
    }

    @Test
    public void testGroupBy2() {

        Integer reduce = userList().stream()
                .map(User::getAge)
                .reduce(
                        0,
                        Integer::sum
                );
    }


}
