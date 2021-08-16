package fish.study.security.verificate;

import fish.study.security.SpringSecurityAuthenticationCode;

/**
 * @author: malin
 * @date:2020/4/24 验证码验证
 **/
public class VerificationAuthentication extends SpringSecurityAuthenticationCode {

    public VerificationAuthentication(String verificationCode, long time) {
        super(verificationCode, time);
    }
}
