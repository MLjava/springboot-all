package fish.study.security.provider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 权限提供者处理类
 *
 * @author: malin
 * @date:2020/5/7
 **/
public interface SpringSecurityAuthorizeManager {

    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
