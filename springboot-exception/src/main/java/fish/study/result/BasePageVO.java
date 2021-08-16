package fish.study.result;

import lombok.Data;

/**
 * @author: malin
 * @date:2020/5/20
 **/
@Data
public class BasePageVO<T> {

    private Integer pageSize;

    private Integer currentPage;

    private Integer code;

    private String message;

    private T data;
}
