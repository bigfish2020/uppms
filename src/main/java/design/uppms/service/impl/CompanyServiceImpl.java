package design.uppms.service.impl;

import design.uppms.model.po.CompanyPO;
import design.uppms.mapper.CompanyMapper;
import design.uppms.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyPO> implements CompanyService {

}
