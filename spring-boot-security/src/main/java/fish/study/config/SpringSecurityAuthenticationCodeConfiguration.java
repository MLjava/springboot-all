package fish.study.config;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.SpringSecurityAuthenticationCodeGenerator;
import fish.study.security.mobile.DefaultMobileAuthenticationGenerator;
import fish.study.security.verificate.DefaultVerificationAuthenticationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: malin
 * @date:2020/4/26
 **/
@Configuration
public class SpringSecurityAuthenticationCodeConfiguration {

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    /**
     * 验证码生成器
     */
    @ConditionalOnMissingBean(name = "defaultSecurityAuthenticationVerificationCodeHandler")
    @Bean
    public SpringSecurityAuthenticationCodeGenerator verificationAuthenticationGenerator() {
        return new DefaultVerificationAuthenticationGenerator(springSecurityProperties);
    }

    /**
     * 短信验证码登录自动生成
     */
    @Bean
    @ConditionalOnMissingBean(name = "defaultMobileAuthenticationGenerator")
    public SpringSecurityAuthenticationCodeGenerator mobileAuthenticationGenerator() {
        return new DefaultMobileAuthenticationGenerator(springSecurityProperties);
    }

}
