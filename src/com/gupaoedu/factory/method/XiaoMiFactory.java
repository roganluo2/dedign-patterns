package com.gupaoedu.factory.method;

/**
 * Created by 召君王 on 2019/3/10.
 */
public class XiaoMiFactory implements PhoneFactory{
    @Override
    public Phone create() {
        return new XiaoMiPhone();
    }
}
