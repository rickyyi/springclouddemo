package cn.cookie.springclouddemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yizhiqiang on 2019/7/24.
 */
@FeignClient(name = "time-service", value = "time-service", configuration = FeignClientsConfiguration.class)
public interface MyServerFeignService {

    @RequestMapping(value = "/myTime", method = RequestMethod.GET)
    String queryMyTime();
}
