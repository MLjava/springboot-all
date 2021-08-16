package fish.study.result;

import fish.study.exception.BaseException;
import fish.study.exception.BaseExceptionEnum;

import javax.validation.constraints.NotNull;

/**
 * @author: malin
 * @date:2020/5/20
 **/
public class BaseVOUtils {

    private BaseVOUtils() {
    }

    public static <T> BaseVO<T> success(T data) {
        BaseVO<T> successBase = new BaseVO<>();
        successBase.setDate(data);
        successBase.setMessage("请求成功");
        successBase.setCode(200);
        return successBase;
    }

    public static <E extends BaseException> BaseVO<E> failure(@NotNull BaseException baseException) {
        BaseVO<E> failureBase = new BaseVO<>();
        BaseExceptionEnum exceptionEnum = BaseExceptionEnum.of(baseException);
        failureBase.setMessage(exceptionEnum.getMessage());
        failureBase.setCode(exceptionEnum.getCode());
        return failureBase;
    }
}
