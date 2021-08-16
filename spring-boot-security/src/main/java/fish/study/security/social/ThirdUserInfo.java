package fish.study.security.social;

/**
 * @author: malin
 * @date: 2020/7/9 1:30 下午
 * 获取用户信息
 **/
public interface ThirdUserInfo<T> {


    /**
     * 获取第三方用户信息
     */
    T getThirdUserInfo();

}
