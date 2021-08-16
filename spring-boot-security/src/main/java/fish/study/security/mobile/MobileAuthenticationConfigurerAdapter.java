package fish.study.security.mobile;

import fish.study.properties.SpringSecurityProperties;
import fish.study.security.SpringSecurityAuthenticationFailureHandler;
import fish.study.security.SpringSecurityAuthenticationSuccessHandler;
import fish.study.security.SpringSecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author: malin
 * @date:2020/4/29
 **/
@Component
public class MobileAuthenticationConfigurerAdapter
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private SpringSecurityUserDetailsService springSecurityUserDetailsService;

    @Autowired
    private SpringSecurityProperties springSecurityProperties;

    @Autowired
    private SpringSecurityAuthenticationFailureHandler failureHandler;

    @Autowired
    private SpringSecurityAuthenticationSuccessHandler successHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsService(springSecurityUserDetailsService);

        MobileAuthenticationFilter mobileAuthenticationFilter = new MobileAuthenticationFilter(springSecurityProperties);
        mobileAuthenticationFilter.setAuthenticationSuccessHandler(successHandler);
        mobileAuthenticationFilter.setAuthenticationFailureHandler(failureHandler);
        mobileAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

        http
                .addFilterAfter(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(provider);

    }
}
