package fish.study.security;

import java.time.LocalDateTime;

/**
 * @author: malin
 * @date:2020/4/26 统一验证码匹配
 **/
public class SpringSecurityAuthenticationCode {

    private LocalDateTime expireTime;

    private String code;

    public SpringSecurityAuthenticationCode(String code, long time) {
        this.expireTime = LocalDateTime.now().plusMinutes(time);
        this.code = code;
    }

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SpringSecurityAuthenticationCode{" +
                "expireTime=" + expireTime +
                ", code='" + code + '\'' +
                '}';
    }
}
