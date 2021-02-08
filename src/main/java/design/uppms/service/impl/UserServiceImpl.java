package design.uppms.service.impl;

import design.uppms.model.po.UserPO;
import design.uppms.mapper.UserMapper;
import design.uppms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

}
