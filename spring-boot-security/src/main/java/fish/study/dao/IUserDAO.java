package fish.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fish.study.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: malin
 * @date:2020/4/22
 **/
@Repository
public interface IUserDAO extends BaseMapper<UserEntity> {

    /**
     * 根据用户账户查询用户信息
     *
     * @param username 用户账户
     * @return 用户信息
     */
    UserEntity findUserByUsername(@Param("username") String username);

}
