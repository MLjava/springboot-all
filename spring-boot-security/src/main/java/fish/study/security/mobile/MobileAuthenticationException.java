package fish.study.security.mobile;

import fish.study.security.SpringSecurityAuthenticationException;

/**
 * @author: malin
 * @date:2020/4/26 短信验证码异常
 **/
public class MobileAuthenticationException extends SpringSecurityAuthenticationException {

    public MobileAuthenticationException(String msg) {
        super(msg);
    }

}
