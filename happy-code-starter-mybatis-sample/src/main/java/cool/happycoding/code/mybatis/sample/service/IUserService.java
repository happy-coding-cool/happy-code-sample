package cool.happycoding.code.mybatis.sample.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.happycoding.code.mybatis.sample.dao.entity.User;
import cool.happycoding.code.mybatis.sample.dto.UserDTO;
import cool.happycoding.code.mybatis.sample.dto.form.UserAddForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserQryForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserQryPageForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserUpdateForm;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2021/02/26 2:43 下午
 */
public interface IUserService extends IService<User> {

    /**
     * 根据Id获取User
     * @param id
     * @return
     */
    UserDTO get(String id);

    /**
     * 根据条件获取用户列表
     * @param userQryForm
     * @return
     */
    List<UserDTO> list(UserQryForm userQryForm);

    /**
     * 分页查询
     * @param userQryPageForm
     * @return
     */
    IPage<UserDTO> page(UserQryPageForm userQryPageForm);

    /**
     * 保存用户
     * @param userAddForm
     * @return
     */
    UserDTO save(UserAddForm userAddForm);

    /**
     * 更新用户信息
     * @param userUpdateForm
     * @return
     */
    Boolean update(UserUpdateForm userUpdateForm);
}

