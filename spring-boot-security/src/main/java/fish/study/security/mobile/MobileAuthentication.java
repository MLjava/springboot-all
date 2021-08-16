package fish.study.security.mobile;

import fish.study.security.SpringSecurityAuthenticationCode;

/**
 * @author: malin
 * @date:2020/4/26 短信验证码
 **/
public class MobileAuthentication extends SpringSecurityAuthenticationCode {

    public MobileAuthentication(String code, long time) {
        super(code, time);
    }
}
