package fish.study.security;

import fish.study.entity.UserEntity;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author: malin
 * @date:2020/4/22 用户基本信息
 **/
public class SpringSecurityUserDetails implements UserDetails {

    /**
     * 当前用户信息详情
     */
    private UserEntity currentUserInfo;

    /**
     * 用户权限
     */
    private List<? extends GrantedAuthority> authorities;

    public SpringSecurityUserDetails(@NonNull UserEntity currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

    public SpringSecurityUserDetails(@NonNull UserEntity currentUserInfo,
                                     @NonNull List<? extends GrantedAuthority> authorities) {
        this(currentUserInfo);
        this.authorities = authorities;
    }

    public UserEntity getCurrentUserInfo() {
        return currentUserInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUserInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUserInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
