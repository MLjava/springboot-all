package fish.study.security.mobile;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.SpringSecurityAuthenticationProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
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
 * @date:2020/4/29 手机验证码匹配逻辑
 **/
@Component
public class MobileCodeFilter extends OncePerRequestFilter
        implements InitializingBean {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private Map<String, SpringSecurityAuthenticationProcessor> processors;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String mobileCode = request.getParameter("mobileCode");
        String requestURI = request.getRequestURI();
        boolean flag = false;
        for (String mobileCodeUrl : springSecurityProperties.getMobile().getMobileCodeUrls()) {
            if (antPathMatcher.match(mobileCodeUrl, requestURI)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            boolean match = processors.get("mobileAuthenticationProcessor")
                    .codeMatch(new ServletWebRequest(request, response), mobileCode, "mobileAuthenticationGenerator");
            if (!match) {
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
