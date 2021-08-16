package fish.study.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: malin
 * @date: 2020/6/22 4:39 下午
 **/
@TableName("test")
@Data
public class TestEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String email;

    private Integer age;

    /**
     * 默认赋值
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

}
