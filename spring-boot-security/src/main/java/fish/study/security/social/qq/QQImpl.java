package fish.study.security.social.qq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @author: malin
 * @date: 2020/7/7 11:07 上午
 **/
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    /**
     * 获取openid的请求地址
     */
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 获取用户信息的请求地址
     */
    private static final String URL_GET_USER_INFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private final String appId;

    private final String openId;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public QQImpl(String accessToken, String appId) {
        // 调用父类构造器，通过参数进行拼接
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    @Override
    public QQUserInfo getUserInfo() {
        //拼接成最终的获取用户信息的请求地址
        String url = String.format(URL_GET_USER_INFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        QQUserInfo userInfo;
        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }
}
