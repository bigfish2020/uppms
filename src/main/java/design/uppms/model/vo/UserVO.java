package design.uppms.model.vo;

import lombok.Data;

@Data
public class UserVO {
    private Integer uId;

    //18位身份证号
    private String uNumber;

    //用户姓名
    private String uName;

    //value = "0:学生  1:实习生  2:企业实习管理员  3:校方实习负责人  4:校方毕业设计指导老师  5:辅导员"
    private Integer uAttribute;

    //密码
    private String uPassword;

    //11位手机号
    private String uPhone;
}
