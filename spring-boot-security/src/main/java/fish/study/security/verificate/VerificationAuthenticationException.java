package fish.study.security.verificate;

import fish.study.security.SpringSecurityAuthenticationException;

/**
 * @author: malin
 * @date:2020/4/24 验证码异常
 **/
public class VerificationAuthenticationException extends SpringSecurityAuthenticationException {

    public VerificationAuthenticationException(String msg) {
        super(msg);
    }
}
