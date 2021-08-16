package fish.study.dao;

import fish.study.SpringSecurityApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: malin
 * @date:2020/4/30
 **/
class IPermissionDAOTest extends SpringSecurityApplicationTest {

    @Autowired
    private IPermissionDAO permissionDAO;

    @Test
    void listPermissionsByRole() {
        System.out.println(permissionDAO.listPermissionsByRole(1L));
    }
}