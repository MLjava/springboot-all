package fish.study.security.provider;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author: malin
 * @date:2020/5/7
 **/
@Component
@Order
public class RbacAuthorizeConfigProvider implements SpringSecurityAuthorizeConfigProvider {

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .anyRequest()
                .access("@springSecurityUserDetailsServiceImpl.hasAuthorities(request, authentication)");
    }
}
