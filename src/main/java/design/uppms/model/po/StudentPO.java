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
@TableName("student")
@ApiModel(value="StudentPO对象", description="")
public class StudentPO implements Serializable {


    @TableId(value = "sId", type = IdType.AUTO)
    private Integer sId;

    @ApiModelProperty(value = "专业")
    @TableField("sProfessional")
    private String sProfessional;

    @ApiModelProperty(value = "年级")
    @TableField("sGrade")
    private String sGrade;

    @ApiModelProperty(value = "学院")
    @TableField("sCollege")
    private String sCollege;

    @ApiModelProperty(value = "辅导员代号")
    @TableField("sCounselorCode")
    private String sCounselorCode;

    @ApiModelProperty(value = "报名状态，0未报名，1报名待审核，2报名审核通过，3报名审核不通过")
    @TableField("sApplyStatus")
    private Integer sApplyStatus;

    @ApiModelProperty(value = "在校状态")
    @TableField("sSchoolStatus")
    private Integer sSchoolStatus;


}
