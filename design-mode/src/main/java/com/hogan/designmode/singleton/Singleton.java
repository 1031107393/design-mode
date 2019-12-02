package com.hogan.designmode.singleton;

/**
 * 饿汉式单例
 * wujun
 * 2019/11/20 21:54
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton get() {
        return singleton;
    }
}
