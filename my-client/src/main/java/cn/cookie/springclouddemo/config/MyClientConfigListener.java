package cn.cookie.springclouddemo.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * Created by yizhiqiang on 2019/7/26.
 */
public class MyClientConfigListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment environment = applicationEnvironmentPreparedEvent.getEnvironment();
        String port = environment.getProperty("server.port");

        Properties properties = new Properties();
        properties.put("RUN_PROPERTY", 8891);
        properties.put("cookie.aws.s3.bucketName", "bucketName123");
        environment.getPropertySources().addFirst(new PropertiesPropertySource("run-profile", properties));
    }
}
