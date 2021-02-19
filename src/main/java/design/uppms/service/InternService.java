package design.uppms.service;

import design.uppms.model.po.InternPO;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

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

}
