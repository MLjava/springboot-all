package fish.study.security.social.qq;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author: malin
 * @date: 2020/7/7 5:54 下午
 **/
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQOAuthe2ServiceProvider(appId, appSecret), new QQApiAdpater());
    }
}
