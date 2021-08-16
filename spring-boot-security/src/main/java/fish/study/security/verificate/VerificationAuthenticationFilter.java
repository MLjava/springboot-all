package fish.study.security.verificate;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.SpringSecurityAuthenticationProcessor;
import fish.study.security.SpringSecurityConstants;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: malin
 * @date:2020/4/24 验证码校验逻辑过滤器
 **/
@Component
public class VerificationAuthenticationFilter extends OncePerRequestFilter
        implements InitializingBean {

    @Autowired
    private Map<String, SpringSecurityAuthenticationProcessor> processors;

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    /**
     * spring security 路劲匹配工具类
     */
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 验证码匹配核心逻辑
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String code = request.getParameter("verification");
        // 开启验证码逻辑
        if (springSecurityProperties.getVerification().isOpenVerification()) {
            // 首页验证保证一定需要验证码
            String requestURI = request.getRequestURI();
            boolean flag = false;
            // 匹配请求规则的url
            for (String verificationUrl : springSecurityProperties.getVerification().getVerificationUrls()) {
                if (antPathMatcher.match(verificationUrl, requestURI)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                boolean match = processors.get("verificationAuthenticationProcessor")
                        .codeMatch(new ServletWebRequest(request, response), code, "verificationAuthenticationGenerator");
                if (!match) {
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        springSecurityProperties.getVerification().setVerificationUrls(springSecurityProperties.getLoginProcessUrl());
    }
}
