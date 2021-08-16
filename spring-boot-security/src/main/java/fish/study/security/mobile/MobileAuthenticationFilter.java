package fish.study.security.mobile;

import fish.study.properties.SpringSecurityProperties;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: malin
 * @date:2020/4/26 短信验证码登录过滤器
 **/
public class MobileAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "mobile";

    /**
     * 手机号码参数
     */
    private String mobileParameter = SPRING_SECURITY_FORM_MOBILE_KEY;

    private boolean postOnly = true;

    /**
     * 只支持post的http请求
     */
    private static final String HTTP_METHOD_SUPPORT = "POST";

    public MobileAuthenticationFilter(SpringSecurityProperties securityProperties) {
        super(new AntPathRequestMatcher(securityProperties.getMobile().getMobileAuthenticationUrl(), HTTP_METHOD_SUPPORT));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !HTTP_METHOD_SUPPORT.equals(request.getMethod())) {
            throw new AuthenticationServiceException(
                    "当前请求方式不支持: " + request.getMethod());
        }
        // 从请求参数获取手机号值
        String mobile = obtainMobile(request);
        if (mobile == null) {
            mobile = "";
        }
        mobile = mobile.trim();
        // 封装用户手机号信息，到Token认证信息体里面
        MobileAuthenticationToken authRequest = new MobileAuthenticationToken(mobile);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }


    @Nullable
    protected String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParameter);
    }


    protected void setDetails(HttpServletRequest request,
                              MobileAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public void setMobileParameter(String mobileParameter) {
        Assert.hasText(mobileParameter, "手机号码参数不可以为空！");
        this.mobileParameter = mobileParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getMobileParameter() {
        return mobileParameter;
    }
}
