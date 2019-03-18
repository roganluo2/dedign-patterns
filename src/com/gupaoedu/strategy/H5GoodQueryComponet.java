package com.gupaoedu.strategy;

/**
 * Created by 召君王 on 2019/3/18.
 */
//@Componet  这里需要引入spring
public class H5GoodQueryComponet implements GoodDetailQuery {


    @Override
    public boolean isSupport(Byte type) {
        return type.equals(2);
    }

    @Override
    public Goods queryGood(Integer id) {
//        H5中的查询逻辑
        return null;
    }
}
