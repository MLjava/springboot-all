package fish.study.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: malin
 * @date:2020/5/7
 **/
@Component
public class SpringSecurityAuthorizeMangerImpl implements SpringSecurityAuthorizeManager {

    @Autowired
    private List<SpringSecurityAuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        authorizeConfigProviders.forEach(authorizeConfigProvider -> authorizeConfigProvider.config(config));
    }
}
