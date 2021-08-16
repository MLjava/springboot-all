package fish.study.security;

import fish.study.base.BaseResult;
import fish.study.enums.SpringSecurityAccessDeniedExceptionEnum;
import fish.study.enums.SpringSecurityAuthenticationExceptionEnum;
import fish.study.properties.SpringSecurityProperties;
import fish.study.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: malin
 * @date:2020/5/20
 **/
@Component
public class SpringSecurityDeniedHandler extends AccessDeniedHandlerImpl {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (springSecurityProperties.isRestAuthentication()) {
            SpringSecurityAccessDeniedExceptionEnum springSecurityAccessDeniedExceptionEnum =
                    SpringSecurityAccessDeniedExceptionEnum.of(accessDeniedException);
            BaseResult<String> baseResult = new BaseResult<>();
            baseResult.setCode(springSecurityAccessDeniedExceptionEnum.getCode());
            baseResult.setMessage(springSecurityAccessDeniedExceptionEnum.getMessage());
            ResponseUtils.JSONResponsePrint(response, baseResult);
        } else {
            super.handle(request, response, accessDeniedException);
        }
    }
}
