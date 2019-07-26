package cn.cookie.springclouddemo.controller;

import cn.cookie.springclouddemo.feign.HelloFeignService;
import cn.cookie.springclouddemo.feign.MyServerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by yizhiqiang on 2019/7/23.
 */
@RestController
public class MyClientController {

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private HelloFeignService helloFeignService;
    @Resource
    private MyServerFeignService myServerFeignService;

    @GetMapping("getTime")
    public String getTime() {
        return restTemplate.getForEntity("http://time-service", String.class).getBody();
    }

    @GetMapping("getTimeByFeign")
    public Object getTimeByFeign() {
        return myServerFeignService.queryMyTime();
    }

    @GetMapping("searchGithub")
    public Object searchGithub(@RequestParam(name = "key") String key) {
        return helloFeignService.searchRepo(key);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
