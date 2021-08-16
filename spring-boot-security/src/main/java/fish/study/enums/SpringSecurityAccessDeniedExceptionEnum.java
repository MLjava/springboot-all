package fish.study.enums;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.security.access.AccessDeniedException;


/**
 * @author: malin
 * @date:2020/5/8
 **/
public enum SpringSecurityAccessDeniedExceptionEnum {

    /**
     * 空值
     */
    NULL(null, null, ""),

    /**
     *
     */
    ACCESS_DENIED_EXCEPTION(103, "您无权限访问", "AccessDeniedException"),


    /**
     *
     */
    AUTHORIZATION_SERVICE_EXCEPTION(103, "", "AuthorizationServiceException");

    @Getter
    private final Integer code;

    @Getter
    private String message;

    @Getter
    private final String accessDeniedExceptionName;

    SpringSecurityAccessDeniedExceptionEnum(Integer code, String message, String accessDeniedExceptionName) {
        this.code = code;
        this.message = message;
        this.accessDeniedExceptionName = accessDeniedExceptionName;
    }

    public static SpringSecurityAccessDeniedExceptionEnum of(AccessDeniedException accessDeniedException) {
        Class<? extends AccessDeniedException> clazz = accessDeniedException.getClass();
        String name = clazz.getSimpleName();
        for (SpringSecurityAccessDeniedExceptionEnum value : values()) {
            if (value.accessDeniedExceptionName.equals(name)) {
                return value;
            }
        }
        return NULL;
    }

    public static SpringSecurityAccessDeniedExceptionEnum of(AccessDeniedException authException, @NonNull String message) {
        Class<? extends AccessDeniedException> clazz = authException.getClass();
        String name = clazz.getSimpleName();
        for (SpringSecurityAccessDeniedExceptionEnum value : values()) {
            if (value.accessDeniedExceptionName.equals(name)) {
                value.message = message;
                return value;
            }
        }
        return NULL;
    }
}
