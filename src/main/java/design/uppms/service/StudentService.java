package design.uppms.service;

import design.uppms.model.po.StudentPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenli
 * @since 2021-02-18
 */
public interface StudentService extends IService<StudentPO> {


    //填写学生信息
    public boolean writeInformation(StudentPO studentPO);

    //学生报名
    public boolean sign(StudentPO studentPO);

}
