package cn.cookie.springclouddemo.annotation;

import java.lang.annotation.*;

/**
 * Created by yizhiqiang on 2019/8/16.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RPCClient {
}
