package fish.study.exception;

import lombok.Getter;

/**
 * @author: malin
 * @date:2020/5/20
 **/
public class BaseException extends RuntimeException {

    @Getter
    private final Integer code;

    public BaseException(BaseExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
