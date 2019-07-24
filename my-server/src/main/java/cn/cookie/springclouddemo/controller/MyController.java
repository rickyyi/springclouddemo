package cn.cookie.springclouddemo.controller;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by yizhiqiang on 2019/7/23.
 */
@RestController
public class MyController {

    @Value("${server.port}")
    private int port;

    @GetMapping(name = "myTime")
    public Object m() {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        return "The current time is " + time + "(answered by service running on " + port + ")";
    }
}
