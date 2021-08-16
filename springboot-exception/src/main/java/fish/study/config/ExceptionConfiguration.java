package fish.study.config;

import fish.study.exception.AbstractAssert;
import fish.study.exception.Assert;
import fish.study.exception.DefaultAssert;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: malin
 * @date:2020/5/20
 **/
@Configuration
public class ExceptionConfiguration {

    @ConditionalOnMissingBean(name = "defaultAssert")
    @Bean
    public Assert anAssert() {
        return new DefaultAssert();
    }

}
