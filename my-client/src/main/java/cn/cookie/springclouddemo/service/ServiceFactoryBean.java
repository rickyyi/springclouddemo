package cn.cookie.springclouddemo.service;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * Created by yizhiqiang on 2019/7/29.
 */

public class ServiceFactoryBean implements FactoryBean<Object>{


    private Class<?> aClassName;

    public void setaClassName(Class<?> aClassName) {
        this.aClassName = aClassName;
    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(aClassName.getClassLoader(), new Class[]{aClassName}, new HelloServiceProxy());
    }

    @Override
    public Class<?> getObjectType() {
        return aClassName;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public String toString() {
        return aClassName.getName();
    }
}
