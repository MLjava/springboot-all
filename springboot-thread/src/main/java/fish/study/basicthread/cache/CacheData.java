package fish.study.basicthread.cache;

import fish.study.basicthread.start.Count;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: malin
 * @date: 2020/8/5 11:29 上午
 **/
@Slf4j
public class CacheData<K, V> implements IReadData<K, V> {

    private final IReadData<K, V> readData;

    private final Map<K, Future<V>> cache = new ConcurrentHashMap<>();

    /**
     * 计数器
     */
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    /**
     * 总共循环的次数
     */
    private final static int TOTAL = 2;

    public CacheData(IReadData<K, V> readData) {
        this.readData = readData;
    }

    @Override

    public V readData(K key) {
        while (true) {
            Future<V> value = cache.get(key);
            if (value == null) {
                Callable<V> processing = () -> readData.readData(key);
                FutureTask<V> futureTask = new FutureTask<>(processing);
                value = cache.putIfAbsent(key, futureTask);
                if (value == null) {
                    value = futureTask;
                    futureTask.run();
                }
            }
            try {
                return value.get();
            } catch (InterruptedException | CancellationException e) {
                log.info("意外中断");
                cache.remove(key);
            } catch (ExecutionException e) {
                log.info("重试获取值");
                cache.remove(key);
            }
        }
    }

    @Override
    public V readData(K key, long expireTime, TimeUnit timeUnit) {
        return null;
    }
}
