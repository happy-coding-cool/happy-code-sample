package cool.happycoding.code.mybatis.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.happycoding.code.base.util.HappyCodeUtil;
import cool.happycoding.code.mybatis.sample.dao.entity.User;
import cool.happycoding.code.mybatis.sample.dao.mapper.UserMapper;
import cool.happycoding.code.mybatis.sample.dto.UserDTO;
import cool.happycoding.code.mybatis.sample.dto.form.UserAddForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserQryForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserQryPageForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserUpdateForm;
import cool.happycoding.code.mybatis.sample.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2021/02/26 2:44 下午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDTO get(String id) {
        return this.getById(id).toDTO(UserDTO.class);
    }

    @Override
    public List<UserDTO> list(UserQryForm userQryForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> users = this.list(queryWrapper);
        return HappyCodeUtil.copy(users, UserDTO.class);
    }

    @Override
    public IPage<UserDTO> page(UserQryPageForm userQryPageForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return this.page(new Page<>(userQryPageForm.getCurrent(), userQryPageForm.getSize()),
                queryWrapper).convert(user->user.toDTO(UserDTO.class));
    }

    @Override
    public UserDTO save(UserAddForm userAddForm) {
        User user = userAddForm.toEntity(User.class);
        this.save(user);
        return user.toDTO(UserDTO.class);
    }

    @Override
    public Boolean update(UserUpdateForm userUpdateForm) {
        User user = userUpdateForm.toEntity(User.class);
        return this.updateById(user);
    }
}
