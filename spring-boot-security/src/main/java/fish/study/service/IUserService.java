package fish.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fish.study.entity.*;

import java.util.List;

/**
 * @author: malin
 * @date:2020/5/1
 **/
public interface IUserService extends IService<UserEntity> {

    List<RoleEntity> listRolesByEntity(Long userId);

    List<PermissionEntity> listPermissionsByRole(Long roleId);

    boolean saveBatchUserRoles(List<UserRoleEntity> userRoles);

    boolean saveBatchRolePermissions(List<RolePermissionEntity> rolePermissions);

    boolean saveRole(RoleEntity roleEntity);

    boolean savePermission(PermissionEntity permissionEntity);

    boolean updateRole(RoleEntity roleEntity);

    boolean updatePermission(PermissionEntity permissionEntity);

    boolean deleteRole(Long roleId);

    boolean deletePermission(Long permissionId);

    UserEntity selectUserByUsername(String username);

}
