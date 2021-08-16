package fish.study.mapper;

import fish.study.SpringBootMyBatisPlusApplicationTest;
import fish.study.entity.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: malin
 * @date: 2020/6/22 4:49 下午
 **/
class ITestMapperTest extends SpringBootMyBatisPlusApplicationTest {

    @Autowired
    private ITestMapper testMapper;

    @Test
    public void insertMapper() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("张三");
        testEntity.setEmail("张三@email.com");
        testEntity.setAge(18);
    }

    @Test
    public void modifyMapper() {
        TestEntity origTest = testMapper.selectById(5L);
        if (origTest != null) {
            origTest.setEmail("李四@email.com");
            testMapper.updateById(origTest);
        }
    }


}