package fish.study.security.verificate;

import fish.study.base.BaseResult;
import fish.study.security.AbstractSpringSecurityAuthenticationProcessor;
import lombok.SneakyThrows;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: malin
 * @date:2020/4/28
 **/
@Component("verificationAuthenticationProcessor")
public class VerificationAuthenticationProcessor
        extends AbstractSpringSecurityAuthenticationProcessor<VerificationAuthentication> {

    @Override
    protected void sendAuthenticationCode(ServletWebRequest request, VerificationAuthentication verificationAuthentication)
            throws Exception {
        var result = new BaseResult<VerificationAuthentication>();
        result.setCode(100);
        result.setData(verificationAuthentication);
        result.setMessage("请求成功");
    }

    @SneakyThrows
    @Override
    protected boolean matchDetails(ServletWebRequest request,
                                   VerificationAuthentication sessionAuthenticationCode, String code) throws AuthenticationException {
        try {
            if (sessionAuthenticationCode.isExpire()) {
                throw new VerificationAuthenticationException("验证码已过期");
            }
            if (!code.matches(sessionAuthenticationCode.getCode())) {
                throw new VerificationAuthenticationException("验证码不匹配");
            }
        } catch (AuthenticationException authException) {
            failureHandler.onAuthenticationFailure(request.getRequest(), request.getResponse(), authException);
            return false;
        }
        return true;
    }
}
