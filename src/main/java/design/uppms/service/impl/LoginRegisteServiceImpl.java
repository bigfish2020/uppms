package design.uppms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import design.uppms.common.aliyun.SendSms;
import design.uppms.mapper.UserMapper;
import design.uppms.model.dto.UserDTO;
import design.uppms.model.po.UserPO;
import design.uppms.model.vo.UserVO;
import design.uppms.service.LoginRegisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class LoginRegisteServiceImpl implements LoginRegisteService {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private SendSms sendSms;
    @Autowired
    private RedisTemplate<Object, Integer> redisTemplate;

    //注册
    @Override
    public boolean registeUser(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        BeanUtil.copyProperties(userDTO,userPO);
        int insert = userMapper.insert(userPO);
        if (insert==1){
            return true;
        }else {
            return false;
        }
    }

    //信息提交
    @Override
    public UserDTO submit(UserDTO userDTO) {
        Integer code = RandomUtil.randomInt();
        //发送短信
        sendSms.sendmessage(code);
        //使用redis存入内存
        redisTemplate.opsForValue().set("key",code, Duration.ofHours(23L));
        return userDTO;
    }

}
