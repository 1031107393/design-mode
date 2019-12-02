package com.hogan.designmode.singleton;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

/**
 * TODO
 * wujun
 * 2019/12/02 23:04
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {

       /* CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Process(latch)).start();
        new Thread(new Process(latch)).start();*/

        try {
            Class clz =  Class.forName("com.hogan.designmode.singleton.LazyInnerClassSingleton");
            Constructor constructor = clz.getDeclaredConstructor();
            constructor.setAccessible(true);
            LazyInnerClassSingleton singleton2 = (LazyInnerClassSingleton) constructor.newInstance();
            Thread.sleep(1000);
            LazyInnerClassSingleton singleton1 = LazyInnerClassSingleton.getInstance();
            System.out.println(singleton1);
            System.out.println(singleton2);
            System.out.println(singleton1 == singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Process implements Runnable{

        private CountDownLatch latch;

        public Process(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            latch.countDown();
            LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
            System.out.println(singleton);
        }
    }
}
