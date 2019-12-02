package com.hogan.designmode.singleton;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉单例模式
 * wujun
 * 2019/11/20 22:02
 */
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private static Lock lock = new ReentrantLock();

    private LazySingleton() {
    }

    public static LazySingleton get() {
        if (Objects.nonNull(lazySingleton)) {
            return lazySingleton;
        }
        synchronized(lock){
            if (Objects.nonNull(lazySingleton)) {
                return lazySingleton;
            }
            lazySingleton = new LazySingleton();
            return lazySingleton;
        }
    }
}
