package fish.study.controller;

import fish.study.entity.PermissionEntity;
import fish.study.entity.RoleEntity;
import fish.study.entity.RolePermissionEntity;
import fish.study.entity.UserRoleEntity;
import fish.study.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: malin
 * @date:2020/5/1
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/roles/batch/save")
    public boolean saveBatchUserRoles(@RequestBody List<UserRoleEntity> userRoles) {
        return userService.saveBatchUserRoles(userRoles);
    }

    @PostMapping("/permissions/batch/save")
    public boolean saveBatchRolePermissions(@RequestBody List<RolePermissionEntity> rolePermissions) {
        return userService.saveBatchRolePermissions(rolePermissions);
    }

    @PostMapping("/role/save")
    public boolean saveRole(@RequestBody RoleEntity roleEntity) {
        return userService.saveRole(roleEntity);
    }

    @PostMapping("/permission/save")
    public boolean savePermission(@RequestBody PermissionEntity permissionEntity) {
        return userService.savePermission(permissionEntity);
    }

}
