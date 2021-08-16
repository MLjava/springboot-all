package fish.study.security;

import fish.study.base.BaseResult;
import fish.study.enums.SpringSecurityAuthenticationExceptionEnum;
import fish.study.properties.SpringSecurityProperties;
import fish.study.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: malin
 * @date:2020/4/23 自定义失败处理器
 **/
@Component
public class SpringSecurityAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException authException)
            throws IOException, ServletException {

        if (springSecurityProperties.isRestAuthentication()) {
            SpringSecurityAuthenticationExceptionEnum springSecurityAuthenticationExceptionEnum =
                    SpringSecurityAuthenticationExceptionEnum.of(authException, authException.getMessage());
            BaseResult<String> baseResult = new BaseResult<>();
            baseResult.setCode(springSecurityAuthenticationExceptionEnum.getCode());
            baseResult.setMessage(springSecurityAuthenticationExceptionEnum.getMessage());
            ResponseUtils.JSONResponsePrint(response, baseResult);
        } else {
            super.onAuthenticationFailure(request, response, authException);
        }
    }

}
