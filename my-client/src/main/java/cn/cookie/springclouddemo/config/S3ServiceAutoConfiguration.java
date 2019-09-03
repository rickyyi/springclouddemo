package cn.cookie.springclouddemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by yizhiqiang on 2019/9/3.
 */
@EnableConfigurationProperties({MyProperties.class})
public class S3ServiceAutoConfiguration {
    @Autowired
    private MyProperties myProperties;

    @Bean
    public RedisClient m() {
        String name = myProperties.getBucketName();
        return new RedisClient();
    }

    public static class RedisClient {

    }
}
