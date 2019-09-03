package cn.cookie.springclouddemo.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by yizhiqiang on 2019/8/22.
 */
public class MyNamespaceHandlerSupport extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("scan", new MyBeanDefinitionParser());
    }
}
