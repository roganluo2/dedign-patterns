package com.gupaoedu.strategy;

/**
 * Created by 召君王 on 2019/3/18.
 */
public interface GoodDetailQuery {

    boolean isSupport(Byte type);

    Goods queryGood(Integer id);

}
