package com.hogan.designmode.proxy.cglibproxy;

class CglibMeiPoTest {

    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        Girl target = new Girl();
        CglibMeiPo cglibMeiPo = new CglibMeiPo();
        Girl proxy = (Girl) cglibMeiPo.getProxy(target);
        proxy.findFere();
    }

}