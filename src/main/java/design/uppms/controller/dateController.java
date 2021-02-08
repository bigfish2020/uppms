package design.uppms.controller;

import design.uppms.model.dto.RegisteDTO;
import design.uppms.model.po.StudentPO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "JSON数据")
@RequestMapping("/date")
public class dateController {



    @PostMapping(value = "/StudentPOJSON")
    public StudentPO StudentPOJSON(){
        StudentPO studentPO = new StudentPO();
        studentPO.setSApplyStatus(2);
        studentPO.setSCollege("dfsdf");
        studentPO.setSCounselorCode("srrfsf");
        studentPO.setSGrade("sfesf");
        studentPO.setSProfessional("hjhj");
        studentPO.setSSchoolStatus(9);
        return studentPO;
    }

    @PostMapping(value = "/RegisteDTOJSON")
    public RegisteDTO RegisteDTOJSON(){
        RegisteDTO dto = new RegisteDTO();
        dto.setUName("ssdfd");
        dto.setUPassword("123");
        dto.setUPhone("12345678901");
        dto.setUAttribute(2);
        dto.setUNumber("seffs");
        return dto;
    }



}
