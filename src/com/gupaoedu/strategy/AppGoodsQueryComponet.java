package com.gupaoedu.strategy;

/**
 * Created by 召君王 on 2019/3/18.
 */
//@Componet
public class AppGoodsQueryComponet implements GoodDetailQuery {
    @Override
    public boolean isSupport(Byte type) {
        return type.equals(1);
    }

    @Override
    public Goods queryGood(Integer id) {
        //app查询逻辑
        return null;
    }
}
