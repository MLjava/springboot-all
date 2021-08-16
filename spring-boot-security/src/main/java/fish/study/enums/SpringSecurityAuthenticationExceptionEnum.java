package fish.study.enums;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.security.core.AuthenticationException;

/**
 * @author: malin
 * @date:2020/4/23 异常处理枚举
 **/
public enum SpringSecurityAuthenticationExceptionEnum {

    /**
     * 无效访问
     */
    INSUFFICIENT_AUTHENTICATION_EXCEPTION(105, "访问无效，请到登录页面进行认证操作", "InsufficientAuthenticationException"),

    /**
     * 用户不存在
     */
    USERNAME_NOT_FOUND_EXCEPTION(105, "当前用户不存在", "UsernameNotFoundException"),

    /**
     * 用户或者密码错误
     */
    BAD_CREDENTIALS_EXCEPTION(105, "用户或者密码错误", "BadCredentialsException"),

    /**
     * 验证码相关异常
     */
    VERIFICATION_AUTHENTICATION_EXCEPTION(105, "", "VerificationAuthenticationException"),

    /**
     * 账户锁住异常
     */
    LOCKED_EXCEPTION(105, "账户被锁定", "LockedException"),

    /**
     * 账户已过期
     */
    CREDENTIALS_EXPIRED_EXCEPTION(105, "账户已过期", "CredentialsExpiredException"),

    /**
     * 账户已禁用
     */
    DISABLED_EXCEPTION(105, "账户已禁用", "DisabledException"),

    /**
     * 短信验证码登录异常
     */
    MOBILE_AUTHENTICATION_EXCEPTION(105, "", "MobileAuthenticationException"),

    /**
     * 异常
     */
    SPRING_SECURITY_AUTHENTICATION_EXCEPTION(105, "", "SpringSecurityAuthenticationException"),

    /**
     * 空
     */
    NULL(null, null, "");

    @Getter
    private final Integer code;

    @Getter
    private String message;

    /**
     * 异常全类名
     */
    private final String authExceptionName;

    SpringSecurityAuthenticationExceptionEnum(Integer code, String message, String authExceptionName) {
        this.code = code;
        this.message = message;
        this.authExceptionName = authExceptionName;
    }

    /**
     * @return 处理的枚举
     */
    public static SpringSecurityAuthenticationExceptionEnum of(AuthenticationException authException) {
        Class<? extends AuthenticationException> clazz = authException.getClass();
        String name = clazz.getSimpleName();
        for (SpringSecurityAuthenticationExceptionEnum value : values()) {
            if (value.authExceptionName.equals(name)) {
                return value;
            }
        }
        return NULL;
    }

    public static SpringSecurityAuthenticationExceptionEnum of(AuthenticationException authException, @NonNull String message) {
        Class<? extends AuthenticationException> clazz = authException.getClass();
        String name = clazz.getSimpleName();
        for (SpringSecurityAuthenticationExceptionEnum value : values()) {
            if (value.authExceptionName.equals(name)) {
                value.message = message;
                return value;
            }
        }
        return NULL;
    }

}
