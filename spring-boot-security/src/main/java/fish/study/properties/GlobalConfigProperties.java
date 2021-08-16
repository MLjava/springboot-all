package fish.study.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: malin
 * @date:2020/4/22 全局配置设置
 **/
@EnableConfigurationProperties(value = {SpringSecurityProperties.class,
        SpringBootProperties.class, SpringSocialProperties.class})
@Configuration
public class GlobalConfigProperties {
}
