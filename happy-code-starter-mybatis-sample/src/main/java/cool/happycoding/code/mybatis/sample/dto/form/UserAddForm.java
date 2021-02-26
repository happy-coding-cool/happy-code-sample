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
 * @author lanlanhappy 2021/02/26 2:40 下午
 */
@Data
@ApiModel(value="UserForm对象", description="用户新增")
public class UserAddForm extends BaseForm {

    @ApiModelProperty(name="姓名", required = true)
    @NotBlank
    private String name;

    @ApiModelProperty(name="年龄")
    private Integer age;
    @ApiModelProperty(name="性别")
    private String gender;
    @ApiModelProperty(name="地址")
    private String addr;
    @ApiModelProperty(name="工资")
    private BigDecimal salary;
    @ApiModelProperty(name="备注")
    private String remark;
}