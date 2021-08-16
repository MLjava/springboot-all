package fish.study.exception;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: malin
 * @date:2020/5/20
 **/
public enum BaseExceptionEnum {

    /**
     * 空值
     */
    NULL(null, null, ""),

    BASE_EXCEPTION(1001, "", "BaseException");

    @Getter
    private final Integer code;

    @Getter
    @Setter
    private String message;

    private final String exceptionName;

    BaseExceptionEnum(Integer code, String message, String exceptionName) {
        this.code = code;
        this.message = message;
        this.exceptionName = exceptionName;
    }

    public static BaseExceptionEnum of(@NotNull BaseException baseException) {
        Class<? extends BaseException> clazz = baseException.getClass();
        for (BaseExceptionEnum value : BaseExceptionEnum.values()) {
            if (value.exceptionName.equals(clazz.getSimpleName())) {
                return value;
            }
        }
        return NULL;
    }

    public static BaseExceptionEnum of(@NotNull BaseException baseException,
                                       @NotBlank String message) {
        Class<? extends BaseException> clazz = baseException.getClass();
        for (BaseExceptionEnum value : BaseExceptionEnum.values()) {
            if (value.exceptionName.equals(clazz.getSimpleName())) {
                value.message = message;
                return value;
            }
        }
        return NULL;
    }
}
