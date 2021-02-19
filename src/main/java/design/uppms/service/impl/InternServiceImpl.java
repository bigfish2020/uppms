package design.uppms.service.impl;

import design.uppms.model.po.InternPO;
import design.uppms.mapper.InternMapper;
import design.uppms.service.InternService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
@Service
public class InternServiceImpl extends ServiceImpl<InternMapper, InternPO> implements InternService {

    @Autowired(required = false)
    private InternMapper internMapper;


    //填写每天实习情况
    @Override
    public boolean writeInformation(InternPO internPO, HttpServletRequest request) {
        //判断是不是实习生
        String uAttribute = request.getHeader("uAttribute");
        Integer code = Integer.valueOf(uAttribute);
        if (code==1){
            internMapper.insert(internPO);
            return true;
        }else {
            return false;
        }
    }





}
