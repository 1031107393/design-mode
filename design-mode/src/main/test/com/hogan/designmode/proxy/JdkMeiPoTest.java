package com.hogan.designmode.proxy;

import com.hogan.designmode.proxy.jdkproxy.Boy;
import com.hogan.designmode.proxy.jdkproxy.Human;
import com.hogan.designmode.proxy.jdkproxy.JdkMeiPo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

class JdkMeiPoTest {

    public static void main(String[] args) {
        Boy boy = new Boy();
        JdkMeiPo meiPo = new JdkMeiPo(boy);
        Human proxy = (Human) meiPo.getProxy();
        proxy.findFere();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Human.class});
        try {
            FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}