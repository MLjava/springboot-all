package fish.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author malin
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!!!";
    }

}
