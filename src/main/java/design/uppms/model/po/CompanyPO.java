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
@TableName("company")
@ApiModel(value="CompanyPO对象", description="")
public class CompanyPO implements Serializable {


    @TableId(value = "Cid", type = IdType.AUTO)
    private Integer Cid;

    @ApiModelProperty(value = "公司名字")
    @TableField("Cname")
    private String Cname;

    @ApiModelProperty(value = "公司地点")
    @TableField("Caddress")
    private String Caddress;

    @ApiModelProperty(value = "营业额")
    @TableField("Cturnover")
    private Integer Cturnover;


}
