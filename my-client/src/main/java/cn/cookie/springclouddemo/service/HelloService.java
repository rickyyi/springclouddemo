package cn.cookie.springclouddemo.service;

import cn.cookie.springclouddemo.annotation.RPCClient;

/**
 * Created by yizhiqiang on 2019/7/29.
 */
@RPCClient
public interface HelloService {

    String execute(String url);
}
