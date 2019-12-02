package com.hogan.designmode.singleton;

import java.util.Objects;

/**
 * 内部类实现单例
 * wujun
 * 2019/12/02 22:59
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){
        if (Objects.nonNull(InnerClass.SINGLETON)) {
            throw new RuntimeException("单例已经实例化");
        }
    }

    public static LazyInnerClassSingleton getInstance() {
        LazyInnerClassSingleton singleton = InnerClass.SINGLETON;
        return singleton;
    }

    private static class InnerClass {
        private static final LazyInnerClassSingleton SINGLETON = new LazyInnerClassSingleton();
    }
}
