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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@RestController
@Api(tags = "实习生的一些操作")
@RequestMapping("/Intern")
public class InternController {

    @Autowired
    private InternService internService;

    @ApiOperation("填写每天实习情况")
    @PostMapping(value = "/WriteInformation")
    public boolean writeInformation(HttpServletRequest request,@RequestPart InternPO internPO){
        return internService.writeInformation(internPO,request);
    }



    @ApiOperation("上传毕业设计资料")
    @PostMapping(value = "/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException, ParseException {
        return internService.upload(file,request);
    }


}
