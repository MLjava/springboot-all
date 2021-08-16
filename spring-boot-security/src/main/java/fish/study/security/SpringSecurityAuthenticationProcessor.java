package fish.study.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: malin
 * @date:2020/4/28
 **/
public interface SpringSecurityAuthenticationProcessor {

    /**
     * 用来发生验证码
     *
     * @param request 用来封装用户请求信息
     */
    void handleAuthenticationCode(ServletWebRequest request, String className);

    /**
     * 密码匹配
     *
     * @param request   请求体信息
     * @param code      要认证的code
     * @param className 名字
     * @throws AuthenticationException 认证异常
     */
    boolean codeMatch(ServletWebRequest request, String code, String className) throws AuthenticationException;
}
