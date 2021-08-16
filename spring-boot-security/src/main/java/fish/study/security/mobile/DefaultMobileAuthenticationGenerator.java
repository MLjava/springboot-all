package fish.study.security.mobile;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.SpringSecurityAuthenticationCode;
import fish.study.security.SpringSecurityAuthenticationCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author: malin
 * @date:2020/4/26 默认的短信验证码登录生成器
 **/
@Slf4j
public class DefaultMobileAuthenticationGenerator implements SpringSecurityAuthenticationCodeGenerator {

    private final SpringSecurityProperties springSecurityProperties;

    public DefaultMobileAuthenticationGenerator(SpringSecurityProperties springSecurityProperties) {
        this.springSecurityProperties = springSecurityProperties;
    }

    @Override
    public SpringSecurityAuthenticationCode generator() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        uuid = StringUtils.substring(uuid, 0, springSecurityProperties.getMobile().getLength());
        log.info("18315538270验证码：{}", uuid);
        return new MobileAuthentication(uuid, springSecurityProperties.getMobile().getExpireTime());
    }
}
