package com.hogan.designmode.singleton;

/**
 * 单元素枚举实现单例
 * wujun
 * 2019/12/04 10:37
 */
public enum SingletonEnum implements Cloneable {

    INSTANCE;

    private DemoBean demoBean;

    SingletonEnum() {
        demoBean = new DemoBean();
    }

    public DemoBean getDemoBean() {
        return demoBean;
    }

    public static DemoBean getInstance() {
        return INSTANCE.demoBean;
    }
}
