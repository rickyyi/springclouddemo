package cn.cookie.springclouddemo.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * Created by yizhiqiang on 2019/7/24.
 */
@Component
public class MyRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> headers = requestTemplate.headers();
        for (String headerName: headers.keySet()) {
            Collection<String> headerValue = headers.get(headerName);
        }
    }
}
