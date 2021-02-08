package design.uppms.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value="UserPO对象", description="")
public class UserPO implements Serializable {


    @TableId(value = "uId", type = IdType.AUTO)
    private Integer uId;

    @ApiModelProperty(value = "18位身份证号")
    @TableField("uNumber")
    private String uNumber;

    @ApiModelProperty(value = "用户姓名")
    @TableField("uName")
    private String uName;

    @ApiModelProperty(value = "0:学生  1:实习生  2:企业实习管理员  3:校方实习负责人  4:校方毕业设计指导老师  5:辅导员")
    @TableField("uAttribute")
    private Integer uAttribute;

    @ApiModelProperty(value = "密码")
    @TableField("uPassword")
    private String uPassword;

    @ApiModelProperty(value = "11位手机号")
    @TableField("uPhone")
    private String uPhone;


}
