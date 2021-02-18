package design.uppms.service;

import design.uppms.model.po.StudentPO;

public interface AuditService {


    //报名审核通过
    public boolean pass(StudentPO studentPO);

    //报名审核不通过
    public boolean nopass(StudentPO studentPO);

}
