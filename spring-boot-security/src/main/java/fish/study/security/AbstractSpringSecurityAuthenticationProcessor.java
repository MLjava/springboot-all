package fish.study.security;

import fish.study.properties.SpringSecurityProperties;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author: malin
 * @date:2020/4/27 统一认证抽象类（模板设计模式）
 **/
public abstract class AbstractSpringSecurityAuthenticationProcessor<T>
        implements SpringSecurityAuthenticationProcessor {

    /**
     * Spring会将所有的的实现封装在这个Map里面
     * key：实现类的名字或者利用configuration注入的方法名字
     * value：当前接口具体实现类
     */
    @Autowired
    protected Map<String, SpringSecurityAuthenticationCodeGenerator> generators;

    /**
     * 用户自定义配置资源类
     */
    @Autowired
    protected SpringSecurityProperties springSecurityProperties;

    /**
     * 统一认证接口实体信息
     */
    private T authenticationCode;

    /**
     * session的工具类
     */
    protected final SessionStrategy sessionRegistry = new HttpSessionSessionStrategy();

    @Autowired
    protected SpringSecurityAuthenticationFailureHandler failureHandler;

    /**
     * 处理整个AuthenticationCode分发处理和保存请求
     *
     * @param request 用来封装用户请求信息
     */
    @Override
    public void handleAuthenticationCode(ServletWebRequest request, String className) {
        // 根据类型名字
        authenticationCode = generatorsByClassName(className);
        try {
            // 发送验证码逻辑
            sendAuthenticationCode(request, authenticationCode);
            saveAuthenticationCode(request, className);
        } catch (Exception e) {

        }
    }

    /**
     * 具体分发动作，应该由子类实现，因为每一个子类的分发动作不一样
     *
     * @param t authenticationCode
     */
    protected abstract void sendAuthenticationCode(ServletWebRequest request, T t) throws Exception;

    /**
     * 具体code逻辑校验应该有子类完成
     *
     * @param code session校验码
     * @throws AuthenticationException 认证异常
     */
    protected abstract boolean matchDetails(ServletWebRequest request, T sessionAuthenticationCode, String code) throws AuthenticationException;

    /**
     * 验证码匹配规则
     *
     * @param code
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    @SuppressWarnings("unchecked")
    public boolean codeMatch(ServletWebRequest request, String code, String className) throws AuthenticationException {
        //从session里面获取验证码信息
        T t = (T) sessionRegistry.getAttribute(request, className);
        try {
            if (t == null) {
                throw new SpringSecurityAuthenticationException("当前session没有存放验证码信息");
            }
        } catch (SpringSecurityAuthenticationException e) {
            failureHandler.onAuthenticationFailure(request.getRequest(), request.getResponse(), e);
            return false;
        }
        // 统一处理密码匹配，并处理异常
        if (matchDetails(request, t, code)) {
            sessionRegistry.removeAttribute(request, className);
            return true;
        }
        return false;
    }


    /**
     * 根据不同的名字
     *
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    private T generatorsByClassName(String className) {
        return (T) generators.get(className).generator();
    }

    private void saveAuthenticationCode(ServletWebRequest request, String className) {
        sessionRegistry.setAttribute(request, className, authenticationCode);
    }

}
