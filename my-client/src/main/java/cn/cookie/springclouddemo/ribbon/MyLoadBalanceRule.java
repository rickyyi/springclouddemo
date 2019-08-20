package cn.cookie.springclouddemo.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * Created by yizhiqiang on 2019/7/25.
 */
public class MyLoadBalanceRule extends AbstractLoadBalancerRule implements EnvironmentAware {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {

        if ("".equals("")) {
            Server server = new Server("192.", 8080);
            return server;
        }

        ILoadBalancer lb = getLoadBalancer();

        return null;
    }

    @Override
    public void setEnvironment(Environment environment) {
        environment.getProperty("");
    }
}
