package com.hogan.designmode.entity;

import java.io.Serializable;

/**
 * TODO
 * wujun
 * 2019/12/04 15:38
 */
public class StreamDemo implements Serializable {

    private StreamDemo child;

    private static final long serialVersionUID = 5269114794741744684L;

    private int num;

    private String name;

    public StreamDemo() {
    }

    public StreamDemo(int num, String name) {
        this.num = num;
        this.name = name;
        this.child = new StreamDemo();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StreamDemo getChild() {
        return child;
    }

    public void setChild(StreamDemo child) {
        this.child = child;
    }
}
