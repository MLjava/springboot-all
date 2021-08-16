package fish.study.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fish.study.SpringSecurityApplicationTest;
import fish.study.entity.RoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: malin
 * @date:2020/4/30
 **/
class IRoleDAOTest extends SpringSecurityApplicationTest {

    @Autowired
    private IRoleDAO roleDAO;

    @Test
    public void findRoles() {
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("enable", true);
        queryWrapper.likeRight("name", "超");
        System.out.println(roleDAO.selectList(queryWrapper));
    }

    @Test
    public void listRolesByUser() {
        System.out.println(roleDAO.listRolesByUser(1L));
    }



}