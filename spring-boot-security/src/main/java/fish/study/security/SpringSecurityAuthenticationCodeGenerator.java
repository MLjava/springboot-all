package fish.study.security;


/**
 * @author: malin
 * @date:2020/4/27 统一处理器认证码生成器模板
 **/
public interface SpringSecurityAuthenticationCodeGenerator {

    /**
     * 生产验证码逻辑
     *
     * @return 返回验证码信息
     */
    SpringSecurityAuthenticationCode generator();

}
