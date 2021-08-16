package fish.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author malin
 */
@SpringBootApplication
// 配置mybatis 扫描包
@MapperScan("fish.study.mapper")
public class SpringBootMyBatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMyBatisPlusApplication.class, args);
    }
}

