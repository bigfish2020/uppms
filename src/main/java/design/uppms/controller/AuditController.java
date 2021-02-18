package design.uppms.controller;

import design.uppms.model.po.StudentPO;
import design.uppms.service.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "审核")
@RequestMapping("/Audit")
public class AuditController {
    @Autowired
    private AuditService auditService;

    @ApiOperation("报名审核通过")
    @PostMapping(value = "/Pass")
    public boolean pass(@RequestPart StudentPO studentPO){
        return auditService.pass(studentPO);
    }

    @ApiOperation("报名审核不通过")
    @PostMapping(value = "/NoPass")
    public boolean nopass(@RequestPart StudentPO studentPO){
        return auditService.nopass(studentPO);
    }


}
