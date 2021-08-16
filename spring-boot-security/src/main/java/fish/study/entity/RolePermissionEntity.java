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
@TableName("role_permission")
public class RolePermissionEntity extends BaseEntity {

    private Long roleId;

    private Long permissionId;
}
