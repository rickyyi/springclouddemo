package cn.cookie.springclouddemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yizhiqiang on 2019/9/3.
 */
@ConfigurationProperties(prefix = "cookie.aws.s3")
@Data
public class MyProperties {
    private String bucketName;
}
