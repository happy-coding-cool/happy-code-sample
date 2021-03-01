package cool.happycoding.code.cache.sample.service.impl;

import cool.happycoding.code.cache.sample.dto.UserBean;
import cool.happycoding.code.cache.sample.service.UserCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 5:11 下午
 */
@Slf4j
@Service
public class UserCacheServiceImpl implements UserCacheService {


    public UserCacheServiceImpl(){
    }

    @Override
    public void saveCacheBean(UserBean userBean) {
        // save
    }


    @Override
    public void delCacheBean(String userId) {
        // del
    }


    @Override
    public UserBean updateCacheBean(UserBean userBean) {
        return userBean;
    }


    @Override
    public UserBean getById(String userId) {
        System.out.println("get Cache Bean id: " +userId);
        return new UserBean(userId, "张三");
    }
}
