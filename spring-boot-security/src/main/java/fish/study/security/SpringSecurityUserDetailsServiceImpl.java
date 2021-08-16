package fish.study.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fish.study.dao.IUserDAO;
import fish.study.entity.PermissionEntity;
import fish.study.entity.RoleEntity;
import fish.study.entity.UserEntity;
import fish.study.security.mobile.MobileAuthenticationToken;
import fish.study.service.IUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: malin
 * @date:2020/4/22
 **/
@Service
public class SpringSecurityUserDetailsServiceImpl implements SpringSecurityUserDetailsService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IUserService userService;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserEntity userEntity = userDAO.selectOne(queryWrapper);
        if (userEntity == null) {
            throw new UsernameNotFoundException("当前用户不存在，请重新选择用户！");
        }
        return new SpringSecurityUserDetails(userEntity);
    }

    @Override
    public boolean hasAuthorities(HttpServletRequest request, Authentication authentication) {
        String username = "anonymousUser" + Math.random();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
            username = token.getName();
        }
        if (authentication instanceof MobileAuthenticationToken) {
            MobileAuthenticationToken token = (MobileAuthenticationToken) authentication;
            username = token.getName();
        }
        UserEntity userEntity = userService.selectUserByUsername(username);
        if (userEntity == null) {
            return false;
        }
        List<RoleEntity> roles = userService.listRolesByEntity(userEntity.getId());
        if (CollectionUtils.isEmpty(roles)) {
            return false;
        }
        for (RoleEntity role : roles) {
            List<PermissionEntity> permissions = userService.listPermissionsByRole(role.getId());
            if (CollectionUtils.isNotEmpty(permissions)) {
                for (PermissionEntity permission : permissions) {
                    if (antPathMatcher.match(permission.getActionUrl(), request.getRequestURI())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
