package design.uppms.service;

import design.uppms.model.po.StudentPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
public interface StudentService extends IService<StudentPO> {
    public boolean writeInformation(StudentPO studentPO);

    public boolean sign(StudentPO studentPO);
}
