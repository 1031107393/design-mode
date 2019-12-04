package com.hogan.designmode.singleton;

import java.io.Serializable;
import java.util.Objects;

/**
 * 内部类实现单例
 * wujun
 * 2019/12/02 22:59
 */
public class LazyInnerClassSingleton implements Serializable {

    private static final long serialVersionUID = 1734938793070682320L;

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

    private Object readResolve() {
        return InnerClass.SINGLETON;
    }
}
