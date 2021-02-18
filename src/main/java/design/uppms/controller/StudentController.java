package design.uppms.controller;


import design.uppms.model.po.StudentPO;
import design.uppms.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "学生的一些基本操作")
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("学生填写基本信息")
    @PostMapping(value = "/WriteInformation")
    public boolean writeInformation(@RequestPart StudentPO studentPO){
        return studentService.writeInformation(studentPO);
    }

    @ApiOperation("学生报名")
    @PostMapping(value = "/Sign")
    public boolean sign(@RequestPart StudentPO studentPO){
        return studentService.sign(studentPO);
    }


}
