package cool.happycoding.code.mybatis.sample.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
/**
 * description
 *
 * @author lanlanhappy 2021/02/26 2:35 下午
 */
@Data
@TableName("h2user")
public class User extends BaseEntity {

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("gender")
    private String gender;

    @TableField("addr")
    private String addr;

    @TableField("salary")
    private BigDecimal salary;

    @TableField("remark")
    private String remark;
}
