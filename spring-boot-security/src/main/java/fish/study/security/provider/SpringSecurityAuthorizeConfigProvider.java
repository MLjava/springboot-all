package fish.study.security.provider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @author: malin
 * @date:2020/5/7 统一授权配置提供类
 **/
public interface SpringSecurityAuthorizeConfigProvider {

    /**
     *
     * @param config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
