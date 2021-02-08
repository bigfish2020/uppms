package design.uppms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("design.uppms.mapper")
public class UppmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UppmsApplication.class, args);
    }

}
