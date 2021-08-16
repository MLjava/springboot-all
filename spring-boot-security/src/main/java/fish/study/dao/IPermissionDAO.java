package fish.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fish.study.entity.PermissionEntity;
import fish.study.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: malin
 * @date:2020/4/29
 **/
@Repository
public interface IPermissionDAO extends BaseMapper<PermissionEntity> {

    /**
     * 查询当前角色有哪些资源
     *
     * @param roleId 角色id
     * @return 当前用户拥有所有权限
     */
    List<PermissionEntity> listPermissionsByRole(@Param("roleId") Long roleId);
}
