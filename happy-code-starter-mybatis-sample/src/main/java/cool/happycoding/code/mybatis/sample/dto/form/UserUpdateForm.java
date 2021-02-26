package cool.happycoding.code.mybatis.sample.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * description
 *
 * @author lanlanhappy 2021/02/26 3:09 下午
 */
@Data
@ApiModel(value="UserUpdateForm对象", description="用户更新")
public class UserUpdateForm extends BaseForm {

    @ApiModelProperty(name="id")
    @NotBlank
    private String id;
    @ApiModelProperty(name="年龄")
    private Integer age;

    @ApiModelProperty(name="版本")
    private Integer version;

    @ApiModelProperty(name="性别")
    private String gender;
    @ApiModelProperty(name="地址")
    private String addr;
    @ApiModelProperty(name="工资")
    private BigDecimal salary;
    @ApiModelProperty(name="备注")
    private String remark;
}
