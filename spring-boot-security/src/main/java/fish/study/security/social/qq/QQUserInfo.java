package fish.study.security.social.qq;

import lombok.Data;

/**
 * @author: malin
 * @date: 2020/7/7 10:57 上午
 * 封装qq的用户信息
 **/
@Data
public class QQUserInfo {

    /**
     * 用户的唯一id
     */
    private String openId;

    /**
     * 用户名字
     */
    private String nickname;
}
