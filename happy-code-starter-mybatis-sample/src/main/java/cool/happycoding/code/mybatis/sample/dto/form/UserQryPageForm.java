package cool.happycoding.code.mybatis.sample.dto.form;

import cool.happycoding.code.base.pojo.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description
 *
 * @author lanlanhappy 2021/02/26 2:57 下午
 */
@Data
@ApiModel(value="UserPageForm对象", description="用户分页查询")
public class UserQryPageForm extends PageForm {

    @ApiModelProperty(name="姓名", required = true)
    private String name;
    @ApiModelProperty(name="年龄")
    private Integer age;
    @ApiModelProperty(name="性别")
    private String gender;
}
