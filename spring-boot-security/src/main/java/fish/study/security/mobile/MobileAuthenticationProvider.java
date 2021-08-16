package fish.study.security.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: malin
 * @date:2020/4/26 短信验证码登录认证核心流程
 **/
public class MobileAuthenticationProvider implements AuthenticationProvider {

    /**
     * spring security 核心查找用户类
     */
    private UserDetailsService userDetailsService;

    /**
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken authToken = (MobileAuthenticationToken) authentication;
        String mobile = (String) authentication.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);
        if (userDetails == null) {
            throw new MobileAuthenticationException("手机号不存在！");
        }
        MobileAuthenticationToken successAuthenticationToken =
                new MobileAuthenticationToken(mobile, userDetails.getAuthorities());
        successAuthenticationToken.setDetails(authToken);
        return successAuthenticationToken;
    }

    /**
     * 只有为Authentication的子类，才能支持下面的判断
     *
     * @param authentication Authentication的子类
     * @return 如果是Authentication的子类返回true，否则为false
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (MobileAuthenticationToken.class
                .isAssignableFrom(authentication));
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
