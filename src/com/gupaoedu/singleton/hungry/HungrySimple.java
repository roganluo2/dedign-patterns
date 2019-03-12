package com.gupaoedu.singleton.hungry;

/**
 * 饿汉模式写法
 */
public class HungrySimple {

    private HungrySimple(){}

    private final static HungrySimple instance;
//    类加载器就完成创建
    static {
        instance = new HungrySimple();
    }

    public static HungrySimple getInstance() {
        return instance;
    }
}
