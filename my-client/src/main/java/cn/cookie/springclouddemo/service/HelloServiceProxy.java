package cn.cookie.springclouddemo.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yizhiqiang on 2019/7/29.
 */
public class HelloServiceProxy implements InvocationHandler {


    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return restTemplate.getForObject("http://" + (String) args[0], String.class);
    }

    @Override
    public String toString() {
        return "target@" + hashCode();
    }
}
