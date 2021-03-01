package cool.happycoding.code.cache.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 5:08 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean implements Serializable {

    private String userId;
    private String userName;


}
