package fish.study.security;

/**
 * @author: malin
 * @date:2020/4/28
 **/
public interface SpringSecurityConstants {

    /**
     * 流程器名字
     */
    String PROCESSOR_NAME = "%sAuthenticationProcessor";

    /**
     * 生成器名字
     */
    String GENERATOR_NAME = "%sAuthenticationGenerator";

    /**
     * 验证码标识
     */
    String VERIFICATION = "verification";

    /**
     * 手机登录标识
     */
    String MOBILE = "mobile";
}
