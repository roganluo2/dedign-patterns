package com.gupaoedu.factory.method;

/**
 * Created by 召君王 on 2019/3/10.
 */
public class MethodFactoryTest {

    public static void main(String[] args) {
        Phone phone = new XiaoMiFactory().create();
        System.out.println(phone.getName());
    }
}
