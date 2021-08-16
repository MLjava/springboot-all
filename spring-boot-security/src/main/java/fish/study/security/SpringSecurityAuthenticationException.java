package fish.study.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author: malin
 * @date:2020/4/28
 **/
public class SpringSecurityAuthenticationException extends AuthenticationException {

    public SpringSecurityAuthenticationException(String msg) {
        super(msg);
    }
}
