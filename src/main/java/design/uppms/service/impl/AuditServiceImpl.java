package design.uppms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import design.uppms.mapper.StudentMapper;
import design.uppms.model.po.StudentPO;
import design.uppms.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    //报名审核通过
    @Override
    public boolean pass(StudentPO studentPO) {
        //改变状态
        studentPO.setSApplyStatus(2);
        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sUID",studentPO.getSUID());
        studentMapper.update(studentPO,queryWrapper);
        return true;
    }

    //报名审核不通过
    @Override
    public boolean nopass(StudentPO studentPO) {
        //改变状态
        studentPO.setSApplyStatus(3);
        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sUID",studentPO.getSUID());
        studentMapper.update(studentPO,queryWrapper);
        return true;
    }


}
