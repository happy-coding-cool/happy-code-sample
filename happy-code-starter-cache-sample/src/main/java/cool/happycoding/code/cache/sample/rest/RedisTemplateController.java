package cool.happycoding.code.cache.sample.rest;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 4:54 下午
 */
@Slf4j
@Api(tags = "cache组件RedisTemplate使用测试")
@RestController
@RequiredArgsConstructor
@RequestMapping("redis-tpl")
public class RedisTemplateController {

    private final StringRedisTemplate stringRedisTemplate;

    @PostMapping("add-cache/{id}")
    @ApiOperation(value = "添加Cache")
    public BaseResult<String> addCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        stringRedisTemplate.opsForValue().set(id, str);
        log.info("str: {}", str);

        return BaseResult.success(str);
    }

    @GetMapping("get-cache/{id}")
    @ApiOperation(value = "查询Cache")
    public BaseResult<String> getCache(@PathVariable String id){
        return BaseResult.success(stringRedisTemplate.opsForValue().get(id));
    }

    @PutMapping("update-cache/{id}")
    @ApiOperation(value = "更新Cache")
    public BaseResult<?> updateCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        stringRedisTemplate.opsForValue().set(id, str);
        log.info("str: {}", str);
        return BaseResult.success();
    }

    @DeleteMapping("del-cache/{id}")
    @ApiOperation(value = "删除Cache")
    public BaseResult<?> delCache(@PathVariable String id){
        stringRedisTemplate.delete(id);
        return BaseResult.success();
    }
}
