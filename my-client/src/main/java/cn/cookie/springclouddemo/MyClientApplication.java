package cn.cookie.springclouddemo;

import cn.cookie.springclouddemo.annotation.EnableMineConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableMineConfiguration
public class MyClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyClientApplication.class, args);
	}

}
