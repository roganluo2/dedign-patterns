package com.gupaoedu.factory.abstracts;

/**
 * 家电生产厂家
 *
 * Created by 召君王 on 2019/3/10.
 */
interface IHouseholdFactory {
    /**
     * 产品电脑
     * @return
     */
    Computer createCompute();

    /**
     * 产品手机
     * @return
     */
    Phone createPhone();

}
