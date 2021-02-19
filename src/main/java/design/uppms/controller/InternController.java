package design.uppms.controller;

import design.uppms.model.po.InternPO;
import design.uppms.model.po.StudentPO;
import design.uppms.service.InternService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "实习生的一些操作")
@RequestMapping("/Intern")
public class InternController {

    @Autowired
    private InternService internService;

    @ApiOperation("填写每天实习情况")
    @PostMapping(value = "/WriteInformation")
    public boolean writeInformation(HttpServletRequest request,@RequestPart InternPO internPO){
        System.out.println("你好");
        System.out.println(internPO.toString());
        System.out.println("你好");

        return internService.writeInformation(internPO,request);
    }



}
