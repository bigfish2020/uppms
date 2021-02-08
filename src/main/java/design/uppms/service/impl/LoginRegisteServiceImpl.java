package design.uppms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import design.uppms.mapper.UserMapper;
import design.uppms.model.dto.RegisteDTO;
import design.uppms.model.po.UserPO;
import design.uppms.service.LoginRegisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisteServiceImpl implements LoginRegisteService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public boolean registeUser(RegisteDTO registeDTO) {
        UserPO userPO = new UserPO();
        BeanUtil.copyProperties(registeDTO,userPO);
        System.out.println(userPO.toString());
        int insert = userMapper.insert(userPO);
        if (insert==1){
            return true;
        }else {
            return false;
        }
    }
}
