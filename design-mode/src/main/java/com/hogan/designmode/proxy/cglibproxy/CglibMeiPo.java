package com.hogan.designmode.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 * wujun
 * 2019/12/05 14:36
 */
public class CglibMeiPo implements MethodInterceptor {

    private Girl target;

    public Object getProxy(Girl obj) {
        this.target = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result;
        before();
        //result = method.invoke(target, args);
        result = methodProxy.invokeSuper(o, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("请问你的性别");
    }

    private void after() {
        System.out.println("好的，已经开始物色，请等待");
    }
}
