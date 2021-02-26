package cool.happycoding.code.mybatis.sample.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description
 *
 * @author lanlanhappy 2021/02/26 3:08 下午
 */
@Data
@ApiModel(value="UserQryForm对象", description="用户查询")
public class UserQryForm extends BaseForm {

    @ApiModelProperty(name="姓名", required = true)
    private String name;
    @ApiModelProperty(name="年龄")
    private Integer age;
    @ApiModelProperty(name="性别")
    private String gender;
}
