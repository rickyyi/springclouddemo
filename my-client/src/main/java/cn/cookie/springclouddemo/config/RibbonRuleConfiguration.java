package cn.cookie.springclouddemo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yizhiqiang on 2019/7/24.
 */
@Configuration
public class RibbonRuleConfiguration {

    @Bean
    public IRule createRule() {
        return new RandomRule();
    }

    @Bean(name = "myClientConfigListener")
    public ApplicationListener createMyClientConfigListener() {
        return new MyClientConfigListener();
    }
}
