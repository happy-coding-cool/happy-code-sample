package cool.happycoding.code.cache.sample.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import cool.happycoding.code.cache.sample.dto.UserBean;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 5:07 下午
 */
public interface UserCacheService {

    /**
     * 保存
     * @param userBean
     */
    void saveCacheBean(UserBean userBean);

    /**
     * 删除
     * @param userId
     */
    @CacheInvalidate(name="cacheBean.", key="#userId")
    void delCacheBean(String userId);

    /**
     * 更新
     * @param userBean
     * @return
     */
    @CacheUpdate(name="userBean.", key="#userBean.userId", value = "#userBean")
    UserBean updateCacheBean(UserBean userBean);

    /**
     * 获取
     * @param userId
     * @return
     */
    @Cached(name="cacheBean.", key="#userId", expire = 3600)
    UserBean getById(String userId);
}
