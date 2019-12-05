package com.hogan.designmode.proxy.cglibproxy;

/**
 * 男人
 * wujun
 * 2019/12/04 22:56
 */
public class Girl {

    private static String sex;

    static {
        sex = "女人";
    }

    public void findFere() {
        System.out.println(sex + "开始找对象");
    }

    public String getSex() {
        return sex;
    }
}
