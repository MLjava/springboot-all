package fish.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: malin
 * @date:2020/4/29
 **/
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role")
@Data
public class RoleEntity extends BaseEntity {

    /**
     * 角色姓名
     */
    private String name;

    /**
     * 启用状态：
     * 1 -> true:启用状态
     * 2 -> false:关闭状态
     */
    private Boolean enable;

}
