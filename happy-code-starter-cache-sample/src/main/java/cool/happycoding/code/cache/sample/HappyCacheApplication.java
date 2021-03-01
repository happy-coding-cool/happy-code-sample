package cool.happycoding.code.cache.sample;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 4:44 下午
 */
@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = {"cool.happycoding.code.cache.sample"})
public class HappyCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyCacheApplication.class, args);
    }
}
