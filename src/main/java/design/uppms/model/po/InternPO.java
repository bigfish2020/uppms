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
@TableName("intern")
@ApiModel(value="InternPO对象", description="")
public class InternPO implements Serializable {


    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "岗位")
    @TableField("Position")
    private String Position;

    @ApiModelProperty(value = "工作内容描述")
    @TableField("workContent")
    private String workContent;

    @ApiModelProperty(value = "工作考核级别")
    @TableField("assessmentLevel")
    private Integer assessmentLevel;


}
