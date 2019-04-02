package com.gupaoedu.factory.abstracts;

/**
 * 抽象工厂实现类-小米厂家的家用电器工厂
 *
 * Created by 召君王 on 2019/3/10.
 */
public class XiaoMiHouseHoldFactory implements IHouseHoldFactory {
    @Override
    public Computer createCompute() {
        return new XiaoMiCompute();
    }

    @Override
    public Phone createPhone() {
        return new XiaoMiPhone();
    }
}
