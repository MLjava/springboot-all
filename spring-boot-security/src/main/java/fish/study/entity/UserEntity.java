package fish.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: malin
 * @date:2020/4/22 用户详情信息
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class UserEntity extends BaseEntity {

    private String username;

    private String password;

    private String nickname;
}
