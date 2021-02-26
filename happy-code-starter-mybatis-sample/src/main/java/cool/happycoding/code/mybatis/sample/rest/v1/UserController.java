package cool.happycoding.code.mybatis.sample.rest.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.base.result.PageResult;
import cool.happycoding.code.mybatis.sample.dto.UserDTO;
import cool.happycoding.code.mybatis.sample.dto.form.UserAddForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserQryForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserQryPageForm;
import cool.happycoding.code.mybatis.sample.dto.form.UserUpdateForm;
import cool.happycoding.code.mybatis.sample.service.IUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/02/26 2:45 下午
 */
@Slf4j
@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @ApiOperation(value = "保存User", notes = "保存user")
    @PostMapping(value = "/save")
    public BaseResult<UserDTO> save(@RequestBody UserAddForm userForm) {
        log.debug("list with userForm:{}", userForm);
        return ListResult.success(userService.save(userForm));
    }

    @ApiOperation(value = "根据Id获取User", notes = "获取User")
    @GetMapping(value = "/{id}")
    public BaseResult<UserDTO> get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return BaseResult.success(userService.get(id));
    }

    @ApiOperation(value = "根据条件搜索User", notes = "获取user列表")
    @PostMapping(value = "/list")
    public ListResult<UserDTO> list(@RequestBody UserQryForm userQryForm) {
        log.debug("list with userForm:{}", userQryForm);
        return ListResult.success(userService.list(userQryForm));
    }

    @ApiOperation(value = "根据条件分页查询User", notes = "分页获取user列表")
    @PostMapping(value = "/page")
    public PageResult<UserDTO> page(@RequestBody UserQryPageForm userQryPageForm) {
        log.debug("page with UserQryPageForm:{}", userQryPageForm);
        IPage<UserDTO> page = userService.page(userQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "根据Id更新User", notes = "更新user信息")
    @PostMapping(value = "/update")
    public BaseResult<Boolean> update(@RequestBody UserUpdateForm userUpdateForm) {
        log.debug("update with userUpdateForm:{}", userUpdateForm);
        return ListResult.success(userService.update(userUpdateForm));
    }





}
