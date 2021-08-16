package fish.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: malin
 * @date: 2020/7/7 11:01 上午
 **/
@ConfigurationProperties(prefix = "spring-social")
public class SpringSocialProperties {

    private static final QQProperties QQ = new QQProperties();

    public static class QQProperties {

        private String processesUrl = "/auth";

        private String providerId;

        public String getProviderId() {
            return providerId;
        }

        public void setProviderId(String providerId) {
            this.providerId = providerId;
        }

        public String getProcessesUrl() {
            return processesUrl;
        }

        public void setProcessesUrl(String processesUrl) {
            this.processesUrl = processesUrl;
        }
    }

    public static QQProperties getQQ() {
        return QQ;
    }
}
