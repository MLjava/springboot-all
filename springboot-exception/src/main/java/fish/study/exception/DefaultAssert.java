package fish.study.exception;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author: malin
 * @date:2020/5/20
 **/
public class DefaultAssert extends AbstractAssert {

    private BaseExceptionEnum getBaseExceptionEnum(String message) {
        BaseExceptionEnum anEnum = BaseExceptionEnum.valueOf("BASE_EXCEPTION");
        if (StringUtils.isNotEmpty(message)) {
            anEnum.setMessage(message);
        }
        return anEnum;
    }

    @Override
    public void assertNotNull(Object obj) {
        assertNotNull(obj, null);
    }

    @Override
    public void assertNotNull(Object obj, String message) {
        if (Objects.isNull(obj)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertNull(Objects obj) {
        assertNotNull(obj, null);
    }

    @Override
    public void assertNull(Objects obj, String message) {
        if (Objects.nonNull(obj)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertBlank(String str) {
        assertBlank(str, null);
    }

    @Override
    public void assertBlank(String str, String message) {
        if (StringUtils.isNotBlank(str)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertNotBlank(String str) {
        assertBlank(str, null);
    }

    @Override
    public void assertNotBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertEmpty(String str) {
        assertEmpty(str, null);
    }

    @Override
    public void assertEmpty(String str, String message) {
        if (StringUtils.isNotEmpty(str)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertNotEmpty(String str) {
        assertNotEmpty(str, null);
    }

    @Override
    public void assertNotEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertEquals(Object sources, Objects target) {
        assertEquals(sources, target, null);
    }

    @Override
    public void assertEquals(Object sources, Objects target, String message) {
        if (!Objects.equals(sources, target)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertNotEquals(Object sources, Objects target) {
        assertNotEquals(sources, target, null);
    }

    @Override
    public void assertNotEquals(Object sources, Objects target, String message) {
        if (Objects.equals(sources, target)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertTrue(Boolean bool) {
        assertTrue(bool, null);
    }

    @Override
    public void assertTrue(Boolean bool, String message) {
        if (BooleanUtils.isFalse(bool)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertFalse(Boolean bool) {
        assertFalse(bool, null);
    }

    @Override
    public void assertFalse(Boolean bool, String message) {
        if (BooleanUtils.isTrue(bool)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public <T> void assertCollectionEmpty(Collection<T> collection) {
        assertCollectionEmpty(collection, null);
    }

    @Override
    public <T> void assertCollectionEmpty(Collection<T> collection, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public <T> void assertCollectionNotEmpty(Collection<T> collection) {
        assertCollectionNotEmpty(collection, null);
    }

    @Override
    public <T> void assertCollectionNotEmpty(Collection<T> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public <K, V> void assertMapEmpty(Map<K, V> map) {
        assertMapEmpty(map, null);
    }

    @Override
    public <K, V> void assertMapEmpty(Map<K, V> map, String message) {
        if (MapUtils.isNotEmpty(map)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public <K, V> void assertMapNotEmpty(Map<K, V> map) {
        assertMapNotEmpty(map, null);
    }

    @Override
    public <K, V> void assertMapNotEmpty(Map<K, V> map, String message) {
        if (MapUtils.isEmpty(map)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertDateBefore(LocalDate startDate, LocalDate endDate) {
        assertDateBefore(startDate, endDate, null);
    }

    @Override
    public void assertDateBefore(LocalDate startDate, LocalDate endDate, String message) {
        if (startDate.isAfter(endDate)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertDateAfter(LocalDate startDate, LocalDate endDate) {
        assertDateAfter(startDate, endDate, null);
    }

    @Override
    public void assertDateAfter(LocalDate startDate, LocalDate endDate, String message) {
        if (startDate.isBefore(endDate)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertDateBefore(LocalDateTime startDate, LocalDateTime endDate) {
        assertDateBefore(startDate, endDate, null);
    }

    @Override
    public void assertDateBefore(LocalDateTime startDate, LocalDateTime endDate, String message) {
        if (startDate.isAfter(endDate)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }

    @Override
    public void assertDateAfter(LocalDateTime startDate, LocalDateTime endDate) {
        assertDateAfter(startDate, endDate, null);
    }

    @Override
    public void assertDateAfter(LocalDateTime startDate, LocalDateTime endDate, String message) {
        if (startDate.isBefore(endDate)) {
            throw new BaseException(getBaseExceptionEnum(message));
        }
    }
}
