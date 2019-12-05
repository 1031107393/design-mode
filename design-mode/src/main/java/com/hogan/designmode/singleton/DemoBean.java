package com.hogan.designmode.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * TODO
 * wujun
 * 2019/12/04 10:37
 */
public class DemoBean implements Cloneable, Serializable {

    private static final long serialVersionUID = 1734938793070682320L;

    private List<DemoBean> lists;

    private Integer i;

    private String s;

    public DemoBean() {
    }

    public List<DemoBean> getLists() {
        return lists;
    }

    public void setLists(List<DemoBean> lists) {
        this.lists = lists;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    protected DemoBean clone() {
        try {
            /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DemoBean.obj"));
            oos.writeObject(this);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DemoBean.obj"));
            DemoBean demoBean = (DemoBean) ois.readObject();
            return demoBean;*/
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream bis = new ObjectInputStream(bais);
            return (DemoBean) bis.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
