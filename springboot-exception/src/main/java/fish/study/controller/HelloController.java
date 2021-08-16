package fish.study.controller;

import fish.study.exception.Assert;
import fish.study.result.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: malin
 * @date:2020/5/20
 **/
@RestController
public class HelloController {

    @Autowired
    private Assert anAssert;

    @GetMapping("/test")
    public BaseVO<String> testException() {
        String name = "张胜男";
        anAssert.assertBlank(name, "name:不可以为空！");
        return new BaseVO<>();
    }
}
