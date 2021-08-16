package fish.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: malin
 * @date:2020/4/29
 **/
@Data
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private String createUser;

    private String modifyUser;
}
