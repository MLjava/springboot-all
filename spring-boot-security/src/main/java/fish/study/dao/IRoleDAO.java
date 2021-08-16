package fish.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fish.study.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: malin
 * @date:2020/4/29
 **/
@Repository
public interface IRoleDAO extends BaseMapper<RoleEntity> {

    /**
     * 根据用户查询角色
     *
     * @param userId 用户id
     * @return 用户拥有的角色
     */
    List<RoleEntity> listRolesByUser(@Param("userId") Long userId);
}
