package fish.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: malin
 * @date:2020/4/30
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_role")
public class UserRoleEntity extends BaseEntity {

    private Long userId;

    private Long roleId;
}
