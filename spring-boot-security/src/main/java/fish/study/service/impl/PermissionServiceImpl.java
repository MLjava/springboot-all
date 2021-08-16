package fish.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fish.study.dao.IPermissionDAO;
import fish.study.entity.PermissionEntity;
import fish.study.service.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author: malin
 * @date:2020/4/30
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionDAO, PermissionEntity>
        implements IPermissionService {

    @Override
    public IPermissionDAO getBaseMapper() {
        return super.getBaseMapper();
    }
}
