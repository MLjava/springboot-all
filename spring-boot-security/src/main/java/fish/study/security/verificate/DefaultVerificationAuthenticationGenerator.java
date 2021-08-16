package fish.study.security.verificate;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.SpringSecurityAuthenticationCode;
import fish.study.security.SpringSecurityAuthenticationCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author: malin
 * @date:2020/4/23 默认的验证码生成器
 **/
@Slf4j
public class DefaultVerificationAuthenticationGenerator implements SpringSecurityAuthenticationCodeGenerator {

    private final SpringSecurityProperties springSecurityProperties;

    public DefaultVerificationAuthenticationGenerator(SpringSecurityProperties springSecurityProperties) {
        this.springSecurityProperties = springSecurityProperties;
    }

    @Override
    public SpringSecurityAuthenticationCode generator() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        uuid = StringUtils.substring(uuid, 0, springSecurityProperties.getVerification().getLength());
        log.info("验证码为：{}", uuid);
        return new VerificationAuthentication(uuid, springSecurityProperties.getVerification().getExpireTime());
    }
}
