package fish.study.security.provider;

import fish.study.properties.SpringSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 无需授权就可以访问
 *
 * @author: malin
 * @date:2020/5/8
 **/
@Component
@Order(Integer.MIN_VALUE)
public class NonAuthorizeConfigProvider implements SpringSecurityAuthorizeConfigProvider {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers(springSecurityProperties.getIgnoreUrls())
                .permitAll();
    }
}
