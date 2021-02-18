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
        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sUID",studentPO.getSUID());
        if (studentMapper.selectOne(queryWrapper)==null){
            if (studentMapper.insert(studentPO)==1){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    //学生报名
    @Override
    public boolean sign(StudentPO studentPO) {
        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sUID",studentPO.getSUID());
        StudentPO studentPO1 = studentMapper.selectOne(queryWrapper);
        if (studentPO1!=null){
            if (studentPO1.getSApplyStatus()==0){
                studentPO.setSApplyStatus(1);
                studentMapper.update(studentPO,queryWrapper);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
