package fish.study.security;

import fish.study.base.BaseResult;
import fish.study.properties.SpringSecurityProperties;
import fish.study.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: malin
 * @date:2020/4/23 登录成功处理
 **/
@Component
public class SpringSecurityAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    /**
     * 认证之后处理逻辑
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        if (springSecurityProperties.isRestAuthentication()) {
            BaseResult<String> baseResult = new BaseResult<>();
            baseResult.setCode(100);
            baseResult.setMessage("认证成功");
            ResponseUtils.JSONResponsePrint(response, baseResult);
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

}
