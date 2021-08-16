package fish.study.basicthread.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author: malin
 * @date: 2020/8/5 11:29 上午
 **/
public interface IReadData<K, V> {

    V readData(K key);

    V readData(K key, long expireTime, TimeUnit timeUnit);
}
