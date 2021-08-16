package fish.study.config;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.*;
import fish.study.security.mobile.MobileAuthenticationConfigurerAdapter;
import fish.study.security.mobile.MobileCodeFilter;
import fish.study.security.provider.SpringSecurityAuthorizeManager;
import fish.study.security.verificate.VerificationAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: malin
 * @date:2020/4/22 security统一配置类
 **/
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringSecurityUserDetailsService springSecurityUserDetailsService;

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    @Autowired
    private SpringSecurityEntryPoint springSecurityEntryPoint;

    @Autowired
    private SpringSecurityAuthenticationSuccessHandler springSecurityAuthenticationSuccessHandler;

    @Autowired
    private SpringSecurityAuthenticationFailureHandler springSecurityAuthenticationFailureHandler;

    @Autowired
    private SpringSecurityAuthenticationLogout springSecurityAuthenticationLogout;

    @Autowired
    private VerificationAuthenticationFilter verificationAuthenticationFilter;

    @Autowired
    private MobileCodeFilter codeFilter;

    @Autowired
    private MobileAuthenticationConfigurerAdapter mobileAuthenticationConfigurerAdapter;

    @Autowired
    private SpringSecurityAuthorizeManager springSecurityAuthorizeManager;

    @Autowired
    private SpringSecurityDeniedHandler springSecurityDeniedHandler;

    /**
     * 密码加密
     *
     * @return 密码加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .apply(mobileAuthenticationConfigurerAdapter)
                .and()
                .addFilterBefore(codeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(verificationAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                // 配置表单登录页面
                .loginPage(springSecurityProperties.getIndexPageUrl())
                // 配置发送请求路劲
                .loginProcessingUrl(springSecurityProperties.getLoginProcessUrl())
                // 配置成功处理器
                .successHandler(springSecurityAuthenticationSuccessHandler)
                // 配置失败处理器
                .failureHandler(springSecurityAuthenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(springSecurityAuthenticationLogout)
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(springSecurityEntryPoint)
                .accessDeniedHandler(springSecurityDeniedHandler)
                .and()
                .userDetailsService(springSecurityUserDetailsService)
                .csrf()
                .disable();
        // 配置认证管理器
        springSecurityAuthorizeManager.config(http.authorizeRequests());

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置不拦截页面
        web
                .ignoring()
                .antMatchers(springSecurityProperties.ignoring());
    }
}
