package design.uppms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import design.uppms.common.aliyun.SendSms;
import design.uppms.mapper.UserMapper;
import design.uppms.model.dto.UserDTO;
import design.uppms.model.po.UserPO;
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

    //登录
    @Override
    public boolean Login(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        BeanUtil.copyProperties(userDTO,userPO);
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("uPhone",userPO.getUPhone());
        queryWrapper.eq("uPassword",userPO.getUPassword());
        if (userMapper.selectList(queryWrapper).size()>0){
            return true;
        }else {
            return false;
        }
    }

    //注册
    @Override
    public boolean registeUser(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        BeanUtil.copyProperties(userDTO,userPO);
        //判断该身份证号是否已被注册
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("uNumber",userPO.getUNumber());
        UserPO userPO1 = userMapper.selectOne(wrapper);
        if (userMapper.selectOne(wrapper)==null){
            //判断密码合法性
            int leath = userPO.getUPassword().length();
            if (leath>=6&&leath<=12){
                //执行插入操作
                int insert = userMapper.insert(userPO);
                if (insert==1){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
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
