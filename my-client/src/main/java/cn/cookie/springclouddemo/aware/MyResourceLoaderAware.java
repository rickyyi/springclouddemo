package cn.cookie.springclouddemo.aware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Created by yizhiqiang on 2019/8/22.
 */
@Component
public class MyResourceLoaderAware implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource = resourceLoader.getResource("1.txt");
        resource.getDescription();
    }
}
