package fish.study.exception;

import fish.study.result.BaseVO;
import fish.study.result.BaseVOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: malin
 * @date:2020/5/20
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseVO<BaseException>> handlerBaseException(BaseException baseException) {
        return ResponseEntity.ok(BaseVOUtils.failure(baseException));
    }
}
