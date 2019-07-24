package cn.cookie.springclouddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("getTime")
    public String getTime() {
        return restTemplate.getForEntity("http://time-service", String.class).getBody();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
