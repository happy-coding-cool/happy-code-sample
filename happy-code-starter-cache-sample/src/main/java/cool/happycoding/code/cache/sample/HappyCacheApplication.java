package cool.happycoding.code.cache.sample;

import cool.happycoding.code.cache.EnableHappyCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 *
 * @author lanlanhappy 2021/02/27 4:44 下午EnableHappyCache
 */
@SpringBootApplication
@EnableHappyCache(basePackages = {"cool.happycoding.code.cache.sample"})
public class HappyCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyCacheApplication.class, args);
    }
}
