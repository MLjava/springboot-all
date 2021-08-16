package fish.study.dao;

import fish.study.SpringSecurityApplicationTest;
import fish.study.entity.RolePermissionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: malin
 * @date:2020/4/30
 **/
class IRolePermissionDAOTest extends SpringSecurityApplicationTest {

    @Autowired
    private IRolePermissionDAO rolePermissionDAO;

    @Test
    void insertBatch() {
        RolePermissionEntity entity = new RolePermissionEntity();
        List<RolePermissionEntity> list = new ArrayList<>();
        entity.setModifyUser("SYSTEM");
        entity.setCreateUser("SYSTEM");
        entity.setCreateTime(LocalDateTime.now());
        entity.setModifyTime(LocalDateTime.now());
        entity.setRoleId(1L);
        entity.setPermissionId(5L);
        RolePermissionEntity entity2 = new RolePermissionEntity();
        entity2.setModifyUser("SYSTEM");
        entity2.setCreateUser("SYSTEM");
        entity2.setCreateTime(LocalDateTime.now());
        entity2.setModifyTime(LocalDateTime.now());
        entity2.setRoleId(1L);
        entity2.setPermissionId(5L);
        list.add(entity);
        list.add(entity2);
        rolePermissionDAO.insertBatch(list);
    }
}