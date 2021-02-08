package design.uppms;

import design.uppms.mapper.UserMapper;
import design.uppms.model.dto.RegisteDTO;
import design.uppms.service.impl.LoginRegisteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UppmsApplicationTests {
    @Autowired
    private UserMapper user;
    @Autowired
    private LoginRegisteServiceImpl loginRegisteService;



    @Test
    void contextLoads() {
        RegisteDTO dto = new RegisteDTO();
        dto.setUName("ssdfd");
        dto.setUPassword("123");
        dto.setUPhone("12345678901");
        dto.setUAttribute(2);
        dto.setUNumber("seffs");
        loginRegisteService.registeUser(dto);
    }

}
