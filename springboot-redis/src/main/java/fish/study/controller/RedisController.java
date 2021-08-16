package fish.study.controller;

import fish.study.annotation.RedisDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: malin
 * @date:2020/5/9
 **/
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    @RedisDatasource
    public void test(int num) {
        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) stringRedisTemplate.getConnectionFactory();
        if (connectionFactory != null && num != connectionFactory.getDatabase()) {
            connectionFactory.setDatabase(num);
            this.stringRedisTemplate.setConnectionFactory(connectionFactory);
            connectionFactory.resetConnection();
        }
    }

}
