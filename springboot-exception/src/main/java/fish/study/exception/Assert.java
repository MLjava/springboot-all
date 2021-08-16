package fish.study.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author: malin
 * @date:2020/5/20
 **/
public interface Assert {

    void assertNotNull(Object obj);

    void assertNotNull(Object obj, String message);

    void assertNull(Objects obj);

    void assertNull(Objects obj, String message);

    void assertBlank(String str);

    void assertBlank(String str, String message);

    void assertNotBlank(String str);

    void assertNotBlank(String str, String message);

    void assertEmpty(String str);

    void assertEmpty(String str, String message);

    void assertNotEmpty(String str);

    void assertNotEmpty(String str, String message);

    void assertEquals(Object sources, Objects target);

    void assertEquals(Object sources, Objects target, String message);

    void assertNotEquals(Object sources, Objects target);

    void assertNotEquals(Object sources, Objects target, String message);

    void assertTrue(Boolean bool);

    void assertTrue(Boolean bool, String message);

    void assertFalse(Boolean bool);

    void assertFalse(Boolean bool, String message);

    <T> void assertCollectionEmpty(Collection<T> collection);

    <T> void assertCollectionEmpty(Collection<T> collection, String message);

    <T> void assertCollectionNotEmpty(Collection<T> collection);

    <T> void assertCollectionNotEmpty(Collection<T> collection, String message);

    <K, V> void assertMapEmpty(Map<K, V> map);

    <K, V> void assertMapEmpty(Map<K, V> map, String message);

    <K, V> void assertMapNotEmpty(Map<K, V> map);

    <K, V> void assertMapNotEmpty(Map<K, V> map, String message);

    void assertDateBefore(LocalDate startDate, LocalDate endDate);

    void assertDateBefore(LocalDate startDate, LocalDate endDate, String message);

    void assertDateAfter(LocalDate startDate, LocalDate endDate);

    void assertDateAfter(LocalDate startDate, LocalDate endDate, String message);

    void assertDateBefore(LocalDateTime startDate, LocalDateTime endDate);

    void assertDateBefore(LocalDateTime startDate, LocalDateTime endDate, String message);

    void assertDateAfter(LocalDateTime startDate, LocalDateTime endDate);

    void assertDateAfter(LocalDateTime startDate, LocalDateTime endDate, String message);

}
