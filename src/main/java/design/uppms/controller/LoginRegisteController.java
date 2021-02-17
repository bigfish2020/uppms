package design.uppms.controller;

import design.uppms.model.dto.UserDTO;
import design.uppms.model.po.UserPO;
import design.uppms.service.LoginRegisteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "登录注册")
@RequestMapping("/LoginRegiste")
public class LoginRegisteController {

    @Autowired
    private LoginRegisteService loginRegisteService;


    @ApiOperation("登录")
    @PostMapping(value = "/Login")
    public boolean login(@RequestPart UserDTO userDTO){
        return false;
    }

    @ApiOperation("注册")
    @PostMapping(value = "/Registe")
    public boolean registe(@RequestParam Integer code,@RequestPart UserDTO userDTO){
        return loginRegisteService.registeUser(userDTO);
    }

    @ApiOperation("信息提交")
    @PostMapping(value = "/Submit")
    public UserDTO submit(@RequestPart UserDTO userDTO){
        return loginRegisteService.submit(userDTO);
    }


}
