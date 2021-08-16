package fish.study.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: malin
 * @date: 2020/6/22 5:36 下午
 **/
@Configuration
public class MyBatisPlusConfig {

    /**
     * 字段预处理器
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MyBatisPlusObjectHandler();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
