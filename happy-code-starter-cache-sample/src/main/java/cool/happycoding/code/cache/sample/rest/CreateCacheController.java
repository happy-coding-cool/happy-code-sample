package cool.happycoding.code.cache.sample.rest;

import cn.hutool.core.util.StrUtil;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 4:51 下午
 */
@Slf4j
@Api(tags = "cache组件CreateCache注解使用测试")
@RestController
@RequiredArgsConstructor
@RequestMapping("create-cache")
public class CreateCacheController {

    @CreateCache(cacheType = CacheType.REMOTE, name = "cache-remote", expire = 60)
    private Cache<String, String> remoteCache;

    @CreateCache(cacheType = CacheType.LOCAL, name="cache-local", expire = 60)
    private Cache<String, String> localCache;

    @CreateCache(cacheType = CacheType.BOTH, name="cache-both", localExpire = 15, expire = 60)
    private Cache<String, String> bothCache;


    /** create cache remote test start */
    @PostMapping("remote-cache/add/{id}")
    @ApiOperation(value = "添加RemoteCache", notes = "使用声明式缓存@CreateCache， cacheType为remote")
    public BaseResult<String> addRemoteCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        remoteCache.put(id, str);
        log.info("str: {}", str);

        return BaseResult.success(str);
    }

    @GetMapping("remote-cache/get/{id}")
    @ApiOperation(value = "查询RemoteCache", notes = "使用声明式缓存@CreateCache， cacheType为 remote")
    public BaseResult<String> getRemoteCache(@PathVariable String id){
        return BaseResult.success(remoteCache.get(id));
    }

    @PutMapping("remote-cache/update/{id}")
    @ApiOperation(value = "更新RemoteCache", notes = "使用声明式缓存@CreateCache， cacheType为 remote")
    public BaseResult<?> updateRemoteCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        remoteCache.put(id, str);
        log.info("str: {}", str);
        return BaseResult.success();
    }

    @DeleteMapping("remote-cache/del/{id}")
    @ApiOperation(value = "删除RemoteCache", notes = "使用声明式缓存@CreateCache， cacheType为 remote")
    public BaseResult<?> delRemoteCache(@PathVariable String id){
        remoteCache.remove(id);
        return BaseResult.success();
    }
    /** create cache remote test end */

    /** create cache local test start */
    @PostMapping("local-cache/add/{id}")
    @ApiOperation(value = "添加LocalCache", notes = "使用声明式缓存@CreateCache， cacheType为 local")
    public BaseResult<String> addLocalCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        localCache.put(id, str);
        log.info("str: {}", str);
        return BaseResult.success(str);
    }

    @GetMapping("local-cache/get/{id}")
    @ApiOperation(value = "查询LocalCache", notes = "使用声明式缓存@CreateCache， cacheType为 local")
    public BaseResult<String> getLocalCache(@PathVariable String id){
        return BaseResult.success(localCache.get(id));
    }

    @PutMapping("local-cache/update/{id}")
    @ApiOperation(value = "更新LocalCache", notes = "使用声明式缓存@CreateCache， cacheType为 local")
    public BaseResult<?> updateLocalCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        localCache.put(id, str);
        log.info("str: {}", str);
        return BaseResult.success();
    }

    @DeleteMapping("local-cache/del/{id}")
    @ApiOperation(value = "删除LocalCache", notes = "使用声明式缓存@CreateCache， cacheType为 local")
    public BaseResult<?> delLocalCache(@PathVariable String id){
        localCache.remove(id);
        return BaseResult.success();
    }
    /** create cache local test end */

    /** create cache both test start */
    @PostMapping("both-cache/add/{id}")
    @ApiOperation(value = "添加BothCache", notes = "使用声明式缓存@CreateCache， cacheType为 both")
    public BaseResult<String> addBothCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        bothCache.put(id, str);
        log.info("str: {}", str);
        return BaseResult.success(str);
    }

    @GetMapping("both-cache/get/{id}")
    @ApiOperation(value = "查询BothCache", notes = "使用声明式缓存@CreateCache， cacheType为 both")
    public BaseResult<String> getBothCache(@PathVariable String id){
        return BaseResult.success(bothCache.get(id));
    }

    @PutMapping("both-cache/update/{id}")
    @ApiOperation(value = "更新BothCache", notes = "使用声明式缓存@CreateCache， cacheType为 both")
    public BaseResult<?> updateBothCache(@PathVariable String id){
        String str = StrUtil.concat(false, id+"###", DateUtils.now());
        bothCache.put(id, str);
        log.info("str: {}", str);
        return BaseResult.success();
    }

    @DeleteMapping("both-cache/del/{id}")
    @ApiOperation(value = "删除BothCache", notes = "使用声明式缓存@CreateCache， cacheType为 both")
    public BaseResult<?> delBothCache(@PathVariable String id){
        bothCache.remove(id);
        return BaseResult.success();
    }
    /** create cache both test end */



}
