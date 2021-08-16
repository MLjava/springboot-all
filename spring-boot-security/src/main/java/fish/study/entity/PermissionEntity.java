package fish.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: malin
 * @date:2020/4/29
 **/
@EqualsAndHashCode(callSuper = true)
@TableName(value = "permission")
@Data
public class PermissionEntity extends BaseEntity {

    /**
     * url路径的名字
     */
    private String name;

    /**
     * url路径
     */
    private String actionUrl;

    /**
     * 启用状态：
     * 1 -> true:启用状态
     * 2 -> false:关闭状态
     */
    private Boolean enable;
}
