package design.uppms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import design.uppms.mapper.StudentMapper;
import design.uppms.mapper.UserMapper;
import design.uppms.model.po.StudentPO;
import design.uppms.model.po.UserPO;
import design.uppms.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired(required = false)
    private StudentMapper studentMapper;
    @Autowired
    private UserMapper userMapper;

    //报名审核通过
    @Override
    public boolean pass(StudentPO studentPO) {
        //改变状态
        studentPO.setSApplyStatus(2);
        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sUID",studentPO.getSUID());
        studentMapper.update(studentPO,queryWrapper);
        //同时改变用户的状态信息
        UserPO userPO = userMapper.selectById(studentPO.getSUID());
        userPO.setUAttribute(1);
        userMapper.updateById(userPO);
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
