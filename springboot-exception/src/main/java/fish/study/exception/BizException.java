package fish.study.exception;

/**
 * @author: malin
 * @date: 2020/6/28 2:29 下午
 **/
public class BizException extends BaseException {


    public BizException(BaseExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
