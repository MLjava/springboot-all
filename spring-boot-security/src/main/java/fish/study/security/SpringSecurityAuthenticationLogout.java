package fish.study.security;

import fish.study.base.BaseResult;
import fish.study.properties.SpringSecurityProperties;
import fish.study.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: malin
 * @date:2020/4/23
 **/
@Component
public class SpringSecurityAuthenticationLogout extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        if (springSecurityProperties.isRestAuthentication()) {
            var baseResult = new BaseResult<String>();
            baseResult.setMessage("注销成功");
            baseResult.setCode(100);
            ResponseUtils.JSONResponsePrint(response, baseResult);
        } else {
            super.onLogoutSuccess(request, response, authentication);
        }
    }
}
