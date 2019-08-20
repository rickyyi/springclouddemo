package cn.cookie.springclouddemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by yizhiqiang on 2019/8/16.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfServerApplication.class, args);
    }
}