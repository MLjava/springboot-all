package fish.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fish.study.dao.IPermissionDAO;
import fish.study.dao.IRoleDAO;
import fish.study.dao.IUserDAO;
import fish.study.dao.IUserRoleDAO;
import fish.study.entity.PermissionEntity;
import fish.study.entity.RoleEntity;
import fish.study.entity.UserEntity;
import fish.study.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: malin
 * @date:2020/4/30
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<IRoleDAO, RoleEntity>
        implements IRoleService {

    @Autowired
    private IPermissionDAO permissionDAO;

    @Override
    public IRoleDAO getBaseMapper() {
        return super.getBaseMapper();
    }
}
