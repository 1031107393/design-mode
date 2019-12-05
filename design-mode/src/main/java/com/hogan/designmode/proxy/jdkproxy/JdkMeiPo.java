package com.hogan.designmode.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 媒婆代理
 * wujun
 * 2019/12/04 22:56
 */
public class JdkMeiPo implements InvocationHandler {

    private Human human;

    public JdkMeiPo(Human human) {
        this.human = human;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(human.getClass().getClassLoader(), human.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        method.invoke(this.human, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("请问你的性别");
    }

    private void after() {
        System.out.println("好的，已经开始物色，请等待");
    }
}
