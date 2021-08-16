package fish.study.security.mobile;

import fish.study.base.BaseResult;
import fish.study.security.AbstractSpringSecurityAuthenticationProcessor;
import fish.study.security.verificate.VerificationAuthenticationException;
import fish.study.utils.ResponseUtils;
import lombok.SneakyThrows;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: malin
 * @date:2020/4/28
 **/
@Component("mobileAuthenticationProcessor")
public class MobileAuthenticationProcessor extends AbstractSpringSecurityAuthenticationProcessor<MobileAuthentication> {

    @Override
    protected void sendAuthenticationCode(ServletWebRequest request, MobileAuthentication mobileAuthentication) throws Exception {
        var result = new BaseResult<MobileAuthentication>();
        result.setData(mobileAuthentication);
        result.setMessage("请求成功！");
        result.setCode(100);
        assert request.getResponse() != null;
        ResponseUtils.JSONResponsePrint(request.getResponse(), result);
    }

    @SneakyThrows
    @Override
    protected boolean matchDetails(ServletWebRequest request, MobileAuthentication sessionAuthenticationCode, String code)
            throws AuthenticationException {
        try {
            if (sessionAuthenticationCode.isExpire()) {
                throw new VerificationAuthenticationException("验证码已过期");
            }
            if (!code.matches(sessionAuthenticationCode.getCode())) {
                throw new VerificationAuthenticationException("验证码不匹配");
            }
        } catch (AuthenticationException e) {
            failureHandler.onAuthenticationFailure(request.getRequest(), request.getResponse(), e);
            return false;
        }
        return true;
    }
}
