package fish.study.security.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * @author: malin
 * @date:2020/4/26 手机验证验证登录Token，这是用来封装用户手机号的信息，接下来所有的认证流程都
 * 需要这个类
 **/
public class MobileAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    /**
     * 手机号码
     */
    private final Object mobile;

    /**
     * 带手机号号码的构造器
     *
     * @param mobile 手机号参数
     */
    public MobileAuthenticationToken(Object mobile) {
        super(null);
        this.mobile = mobile;
        // 开始初创的时候，没有认证的
        setAuthenticated(false);
    }

    /**
     * 认证成功的时候调用的构造器
     *
     * @param mobile      手机号
     * @param authorities 权限
     */
    public MobileAuthenticationToken(Object mobile,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.mobile = mobile;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.mobile;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }

}
