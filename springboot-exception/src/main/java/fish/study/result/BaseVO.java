package fish.study.result;

import lombok.Data;

/**
 * @author: malin
 * @date:2020/5/20
 **/
@Data
public class BaseVO<T> {

    private Integer code;

    private String message;

    private T date;
}
