package design.uppms;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import design.uppms.common.aliyun.SendSms;
import design.uppms.mapper.StudentMapper;
import design.uppms.mapper.UserMapper;
import design.uppms.model.dto.UserDTO;
import design.uppms.model.po.StudentPO;
import design.uppms.model.po.UserPO;
import design.uppms.service.impl.LoginRegisteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.List;

@SpringBootTest
class UppmsApplicationTests {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private LoginRegisteServiceImpl loginRegisteService;
    @Autowired
    private RedisTemplate<Object, Integer> redisTemplate;
    @Autowired
    private SendSms sendSms;
    @Autowired(required = false)
    private StudentMapper studentMapper;


    @Test
    void Test1() {
        UserDTO dto = new UserDTO();
        dto.setUName("ssdfd");
        dto.setUPassword("123");
        dto.setUPhone("12345678901");
        dto.setUAttribute(2);
        dto.setUNumber("seffs");
        loginRegisteService.registeUser(dto);
    }

    @Test
    void Test2() {
        redisTemplate.opsForValue().set("key",23, Duration.ofHours(23L));
        Integer key = redisTemplate.opsForValue().get("key");
        System.out.println("1");
        System.out.println(key);
        System.out.println("2");
    }


    @Test
    void Test3() {
        sendSms.sendmessage(123);
    }

    @Test
    void Test4() {
        System.out.println("111");
        System.out.println(RandomUtil.randomInt());
        System.out.println("222");
    }

    @Test
    void Test5() {
        System.out.println("111");
        System.out.println(RandomUtil.randomString(3));
        System.out.println("222");
    }


    @Test
    void Test6() {

        QueryWrapper<UserPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("uPhone","12345678901");
        queryWrapper.eq("uPassword","1");
        List<UserPO> userPOS = userMapper.selectList(queryWrapper);
        System.out.println("111");
        for (int i =0;i<userPOS.size();i++){
            System.out.println(i);
            System.out.println(userPOS.get(i).toString());
        }
        System.out.println(userPOS.size());
        System.out.println("222");
    }

    @Test
    void Test7() {
        StudentPO studentPO = new StudentPO();
        studentPO.setSApplyStatus(2);
        studentPO.setSCollege("dfsdf");
        studentPO.setSCounselorCode("srrfsf");
        studentPO.setSGrade("sfesf");
        studentPO.setSProfessional("hjhj");
        studentPO.setSSchoolStatus(9);
        studentPO.setSUID(3);


        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sUID",studentPO.getSUID());
        StudentPO studentPO1 = studentMapper.selectOne(queryWrapper);
        System.out.println(studentPO1==null);
    }




}
