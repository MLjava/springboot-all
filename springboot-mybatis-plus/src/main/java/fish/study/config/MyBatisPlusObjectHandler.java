package fish.study.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @author: malin
 * @date: 2020/6/22 4:51 下午
 * 此类用户自动复制
 **/
@Slf4j
public class MyBatisPlusObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("modifyDate", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate", LocalDateTime.now(), metaObject);
    }
}
