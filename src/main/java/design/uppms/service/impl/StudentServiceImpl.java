package design.uppms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import design.uppms.model.po.StudentPO;
import design.uppms.mapper.StudentMapper;
import design.uppms.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenli
 * @since 2021-02-18
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentPO> implements StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    //填写学生信息
    @Override
    public boolean writeInformation(StudentPO studentPO) {
        if (studentMapper.insert(studentPO)==1){
            return true;
        }
        return false;
    }

    //学生报名
    @Override
    public boolean sign(StudentPO studentPO) {
        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sProfessional",studentPO.getSProfessional());
        queryWrapper.eq("sGrade",studentPO.getSGrade());
        queryWrapper.eq("sCollege",studentPO.getSCollege());
        queryWrapper.eq("sCounselorCode",studentPO.getSCounselorCode());
        queryWrapper.eq("sApplyStatus",studentPO.getSApplyStatus());
        studentMapper.selectOne(queryWrapper);
        if (studentMapper.selectById(studentPO.getSId()).getSApplyStatus()==1){
            return false;
        }else {
            studentPO.setSApplyStatus(1);
            studentMapper.updateById(studentPO);
            return true;
        }
    }
}
