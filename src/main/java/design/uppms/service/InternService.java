package design.uppms.service;

import design.uppms.model.po.InternPO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
public interface InternService extends IService<InternPO> {


    //填写每天实习情况
    public boolean writeInformation(InternPO internPO, HttpServletRequest request);

    //上传毕业设计资料
    public String upload(MultipartFile file, HttpServletRequest request) throws ParseException, IOException;

}
