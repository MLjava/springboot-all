package fish.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fish.study.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: malin
 * @date:2020/4/30
 **/
@Repository
public interface IUserRoleDAO extends BaseMapper<UserRoleEntity> {

    /**
     * 批量添加用户角色绑定关系
     *
     * @param userRoles 用户角色关系实体类
     * @return 修改记录标识
     */
    int insertBatch(@Param("userRoles") List<UserRoleEntity> userRoles);

}
