package cn.cookie.springclouddemo.annotation;

import cn.cookie.springclouddemo.service.ServiceRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by yizhiqiang on 2019/8/16.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ServiceRegister.class})
public @interface EnableMineConfiguration {
}
