package fish.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fish.study.dao.*;
import fish.study.entity.*;
import fish.study.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: malin
 * @date:2020/5/1
 **/
@Service
public class UserServiceImpl extends ServiceImpl<IUserDAO, UserEntity> implements IUserService {

    @Autowired
    private IPermissionDAO permissionDAO;

    @Autowired
    private IRoleDAO roleDAO;

    @Autowired
    private IUserRoleDAO userRoleDAO;

    @Autowired
    private IRolePermissionDAO rolePermissionDAO;


    @Override
    public IUserDAO getBaseMapper() {
        return super.getBaseMapper();
    }

    @Override
    public List<RoleEntity> listRolesByEntity(Long userId) {
        return roleDAO.listRolesByUser(userId);
    }

    @Override
    public List<PermissionEntity> listPermissionsByRole(Long roleId) {
        return permissionDAO.listPermissionsByRole(roleId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBatchUserRoles(List<UserRoleEntity> userRoles) {
        return userRoleDAO.insertBatch(userRoles) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBatchRolePermissions(List<RolePermissionEntity> rolePermissions) {
        return rolePermissionDAO.insertBatch(rolePermissions) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRole(RoleEntity roleEntity) {
        return roleDAO.insert(roleEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean savePermission(PermissionEntity permissionEntity) {
        return permissionDAO.insert(permissionEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(RoleEntity roleEntity) {
        if (roleEntity == null
                || roleEntity.getId() == null) {
            throw new RuntimeException("传参有误");
        }
        RoleEntity originRoleEntity = roleDAO.selectById(roleEntity.getId());
        if (originRoleEntity == null) {
            throw new RuntimeException("要更新的数据不存在");
        }
        return roleDAO.updateById(roleEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePermission(PermissionEntity permissionEntity) {
        if (permissionEntity == null
                || permissionEntity.getId() == null) {
            throw new RuntimeException("传参有误");
        }
        PermissionEntity originPermissionEntity = permissionDAO.selectById(permissionEntity.getId());
        if (originPermissionEntity == null) {
            throw new RuntimeException("要删除的数据不存在");
        }
        return permissionDAO.updateById(permissionEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRole(Long roleId) {
        if (roleId == null) {
            throw new RuntimeException("传参有误");
        }
        RoleEntity originRoleEntity = roleDAO.selectById(roleId);
        if (originRoleEntity == null) {
            throw new RuntimeException("要删除的数据不存在");
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deletePermission(Long permissionId) {
        if (permissionId == null) {
            throw new RuntimeException("传参有误");
        }

        PermissionEntity originPermissionEntity = permissionDAO.selectById(permissionId);
        if (originPermissionEntity == null) {
            throw new RuntimeException("要删除的数据不存在");
        }
        return permissionDAO.deleteById(permissionId) > 0;
    }

    @Override
    public UserEntity selectUserByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException("传参有误！");
        }
        return getBaseMapper().findUserByUsername(username);
    }
}
