package cool.happycoding.code.log.sample.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2021/03/19 2:47 下午
 */
@Data
public class LogBean implements Serializable {

    private Date date;
    private BigDecimal b;
    private Long l;
    private Integer i;
    private String str;

}
