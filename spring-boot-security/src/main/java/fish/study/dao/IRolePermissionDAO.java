package fish.study.dao;

import fish.study.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: malin
 * @date:2020/4/30
 **/
@Repository
public interface IRolePermissionDAO {

    /**
     * 批量添加角色资源
     *
     * @param rolePermissions 用户资源实体信息
     * @return 返回更新记录数
     */
    int insertBatch(@Param("rolePermissions") List<RolePermissionEntity> rolePermissions);

}
