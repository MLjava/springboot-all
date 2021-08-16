package fish.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: malin
 * @date:2020/4/26
 **/
@ConfigurationProperties(prefix = "spring-boot")
public class SpringBootProperties {

   private String page404Url = "/404";

    public String getPage404Url() {
        return page404Url;
    }

    public void setPage404Url(String page404Url) {
        this.page404Url = page404Url;
    }
}
