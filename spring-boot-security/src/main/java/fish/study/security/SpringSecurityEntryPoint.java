package fish.study.security;

import fish.study.base.BaseResult;
import fish.study.enums.SpringSecurityAuthenticationExceptionEnum;
import fish.study.properties.SpringSecurityProperties;
import fish.study.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: malin
 * @date:2020/4/23 自定义认证路径
 **/
@Component
public class SpringSecurityEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    /**
     * 地址重定向
     */
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        if (springSecurityProperties.isRestAuthentication()) {
            var baseResult = new BaseResult<String>();
            SpringSecurityAuthenticationExceptionEnum springSecurityAuthenticationExceptionEnum =
                    SpringSecurityAuthenticationExceptionEnum.of(authException);
            baseResult.setMessage(springSecurityAuthenticationExceptionEnum.getMessage());
            baseResult.setCode(springSecurityAuthenticationExceptionEnum.getCode());
            ResponseUtils.JSONResponsePrint(response, baseResult);
        } else {
            redirectStrategy.sendRedirect(request, response, springSecurityProperties.getIndexPageUrl());
        }
    }

}
