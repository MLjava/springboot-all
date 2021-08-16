package fish.study.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: malin
 * @date:2020/4/22 用来获取从数据库里面获取用户详情数据
 **/
public interface SpringSecurityUserDetailsService extends UserDetailsService {

    /**
     * 获取用户权限
     *
     * @param request        认证的url路径
     * @param authentication 认证服务
     * @return 首先成功返回true，否则返回false
     */
    boolean hasAuthorities(HttpServletRequest request, Authentication authentication);
}
