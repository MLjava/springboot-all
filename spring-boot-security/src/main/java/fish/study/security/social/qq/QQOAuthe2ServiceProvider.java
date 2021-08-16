package fish.study.security.social.qq;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author: malin
 * @date: 2020/7/7 11:29 上午
 **/
public class QQOAuthe2ServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    /**
     * 获取授权码地址
     */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    /**
     * 获取用户令牌地址
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    private final String appId;

    public QQOAuthe2ServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
