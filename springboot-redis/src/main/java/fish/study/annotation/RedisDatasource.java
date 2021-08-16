package fish.study.annotation;

import java.lang.annotation.*;

/**
 * @author: malin
 * @date:2020/4/29 用来动态设置redis数据库连接
 **/
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisDatasource {

    /**
     * 目标数据库号
     *
     * @return 当前数据库的目标号
     */
    int datasource() default 0;
}
