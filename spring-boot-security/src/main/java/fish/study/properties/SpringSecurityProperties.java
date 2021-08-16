package fish.study.properties;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: malin
 * @date:2020/4/22 访问权限配置
 **/
@ConfigurationProperties(value = "spring-security")
public class SpringSecurityProperties {

    /**
     * 验证码最大长度
     */
    public static final int MAX_LENGTH = 32;

    /**
     * 验证码最小长度
     */
    public static final int MIN_LENGTH = 4;

    /**
     * spring security登录页面配置
     */
    private String indexPageUrl = "/index/page";

    /**
     * spring security静态资源不拦截配置
     */
    private String[] ignoresResources = new String[]{"/css/**", "/js/**", "/images/**", "/fonts/**", "/lib/**", "/icon/**", "/tools/**", "/svg/**"};

    /**
     * spring security动态地址不拦截配置
     */
    private String[] ignoreUrls = new String[]{indexPageUrl};

    /**
     * spring security登录认证路径
     */
    private String loginProcessUrl = "/spring/security/login";

    /**
     * 验证码配置类
     */
    private final Verification verification = new Verification();

    /**
     * 手机验证码登录相关配置
     */
    private final Mobile mobile = new Mobile();

    /**
     * 开启前后段分离认证标识
     */
    private boolean restAuthentication = false;

    public String getIndexPageUrl() {
        return indexPageUrl;
    }


    public void setIndexPageUrl(String indexPageUrl) {
        this.indexPageUrl = indexPageUrl;
    }

    public String[] getIgnoresResources() {
        return ignoresResources;
    }

    public void setIgnoresResources(String... ignoresResources) {
        this.ignoresResources = ArrayUtils.addAll(this.ignoresResources, ignoresResources);
    }

    public String[] getIgnoreUrls() {
        return ignoreUrls;
    }

    public void setIgnoreUrls(String... ignoreUrls) {
        this.ignoreUrls = ArrayUtils.addAll(this.ignoreUrls, ignoreUrls);
    }

    public String[] ignoring() {
        return ArrayUtils.addAll(this.ignoreUrls, this.ignoresResources);
    }

    public String getLoginProcessUrl() {
        return loginProcessUrl;
    }

    public void setLoginProcessUrl(String loginProcessUrl) {
        this.loginProcessUrl = loginProcessUrl;
    }

    public boolean isRestAuthentication() {
        return restAuthentication;
    }

    public void setRestAuthentication(boolean restAuthentication) {
        this.restAuthentication = restAuthentication;
    }

    public Verification getVerification() {
        return verification;
    }


    public Mobile getMobile() {
        return mobile;
    }

    /**
     * 验证码相关属性配置
     */
    public static class Verification {

        /**
         * 开启验证码匹配
         */
        private boolean openVerification = true;

        /**
         * 验证码过期时间
         */
        private Long expireTime = 2L;

        /**
         * code长度
         */
        private Integer length = MIN_LENGTH;

        /**
         * 需要验证码的路径
         */
        private String[] verificationUrls = new String[]{};

        public Long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }

        public boolean isOpenVerification() {
            return openVerification;
        }

        public void setOpenVerification(boolean openVerification) {
            this.openVerification = openVerification;
        }

        public String[] getVerificationUrls() {
            return verificationUrls;
        }

        public void setVerificationUrls(String... verificationUrls) {
            this.verificationUrls = ArrayUtils.addAll(this.verificationUrls, verificationUrls);
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            if (length == null) {
                length = MIN_LENGTH;
            }
            if (length > MAX_LENGTH) {
                this.length = MAX_LENGTH;
            }
            if (length <= MIN_LENGTH) {
                this.length = MAX_LENGTH;
            }
            this.length = length;
        }
    }

    /**
     * 短信验证码登录相关配置
     */
    public static class Mobile {

        /**
         * 手机号登录验证路径
         */
        private String mobileAuthenticationUrl = "/spring/security/mobile";

        /**
         * 用户自定义
         */
        private String[] mobileCodeUrls = new String[]{mobileAuthenticationUrl};

        private Long expireTime = 2L;

        /**
         * 短信验证码长度
         */
        private Integer length = 6;

        public String getMobileAuthenticationUrl() {
            return mobileAuthenticationUrl;
        }

        public void setMobileAuthenticationUrl(String mobileAuthenticationUrl) {
            this.mobileAuthenticationUrl = mobileAuthenticationUrl;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            if (length == null) {
                length = MIN_LENGTH;
            }
            if (length > MAX_LENGTH) {
                this.length = MAX_LENGTH;
            }
            if (length <= MIN_LENGTH) {
                this.length = MAX_LENGTH;
            }
            this.length = length;
        }

        public Long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }

        public String[] getMobileCodeUrls() {
            return mobileCodeUrls;
        }

        public void setMobileCodeUrls(String... mobileCodeUrls) {
            this.mobileCodeUrls = ArrayUtils.addAll(this.mobileCodeUrls, mobileCodeUrls);
        }
    }
}
