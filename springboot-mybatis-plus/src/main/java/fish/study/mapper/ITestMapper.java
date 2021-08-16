package fish.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fish.study.entity.TestEntity;
import org.springframework.stereotype.Repository;

/**
 * @author: malin
 * @date: 2020/6/22 4:49 下午
 **/
@Repository
public interface ITestMapper extends BaseMapper<TestEntity> {
}
