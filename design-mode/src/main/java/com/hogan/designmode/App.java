package com.hogan.designmode;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        /*Farm farm = new ChongQingFarm();
        Animal cow = farm.produceAnimal();
        Fruit apple = farm.produceFruit();
        cow.show();
        apple.show();*/
        /*MDC.put("user", "wujun");
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(MDC.get("user"));
            }
        };
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MDC.put("user", "wuxing");
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(MDC.get("user"));
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println(MDC.get("user"));
                    }
                }.start();
            }
        };
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();*/

    }
}
