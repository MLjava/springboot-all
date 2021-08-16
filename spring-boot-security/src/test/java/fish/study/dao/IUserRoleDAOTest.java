package fish.study.dao;

import fish.study.SpringSecurityApplicationTest;
import fish.study.entity.UserRoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: malin
 * @date:2020/4/30
 **/
class IUserRoleDAOTest extends SpringSecurityApplicationTest {

    @Autowired
    private IUserRoleDAO userRoleDAO;

    @Test
    public void insertList() {
        List<UserRoleEntity> list = new ArrayList<>();
        UserRoleEntity userEntity = new UserRoleEntity();
        userEntity.setRoleId(2L);
        userEntity.setUserId(2L);
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setModifyTime(LocalDateTime.now());
        userEntity.setCreateUser("SYSTEM");
        userEntity.setModifyUser("SYSTEM");
        list.add(userEntity);
        UserRoleEntity userEntity2 = new UserRoleEntity();
        userEntity2.setRoleId(2L);
        userEntity2.setUserId(3L);
        userEntity2.setCreateTime(LocalDateTime.now());
        userEntity2.setModifyTime(LocalDateTime.now());
        userEntity2.setCreateUser("SYSTEM");
        userEntity2.setModifyUser("SYSTEM");
        list.add(userEntity2);
        userRoleDAO.insertBatch(list);
    }

}