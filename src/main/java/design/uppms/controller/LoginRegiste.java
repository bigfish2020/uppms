package design.uppms.controller;

import design.uppms.model.po.StudentPO;
import design.uppms.model.po.UserPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录注册")
@RequestMapping("/LoginRegiste")
public class LoginRegiste {


    @ApiOperation("登录")
    @PostMapping(value = "/writeInformation")
    public boolean login(@RequestPart UserPO userPO){
        return false;
    }

    @ApiOperation("注册")
    @PostMapping(value = "/sign")
    public boolean registe(@RequestPart UserPO userPO){
        return false;
    }


}
