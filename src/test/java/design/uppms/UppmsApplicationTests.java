package design.uppms;

import design.uppms.mapper.UserMapper;
import design.uppms.model.dto.RegisteDTO;
import design.uppms.service.impl.LoginRegisteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@SpringBootTest
class UppmsApplicationTests {
    @Autowired
    private UserMapper user;
    @Autowired
    private LoginRegisteServiceImpl loginRegisteService;
    @Autowired
    private RedisTemplate<Object, Integer> redisTemplate;


    @Test
    void Test1() {
        RegisteDTO dto = new RegisteDTO();
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





}
