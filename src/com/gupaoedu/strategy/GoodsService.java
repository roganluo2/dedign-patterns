package com.gupaoedu.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品逻辑
 * Created by 召君王 on 2019/3/18.
 */
public class GoodsService /*implements ApplicationContextAware */ {

    /**
     * 根据不同的渠道，展示商品的字段不同
     * @param id
     * @param channelCode
     * @return
     */
//    根据不同的渠道类型，展示不同的属性
    public Goods getGoodDetail(Integer id, Byte channelCode)
    {
        if(channelCode == 1)
        {
            //客户端APP展示的属性
            return null;
        }
        else if(channelCode == 2){
            //手机H5页面展示的属性查询
            return null;
        }
        else if(channelCode == 3)
        {
//            浏览器需要展示的属性
            return null;
        }
        return null;
    }


    //    利用策略模式改写
    public Goods getGoodStrategy(Integer id, Byte channelCode)
    {
//        需要引入spring
        List<GoodDetailQuery> list = new ArrayList<>();
//        List<GoodDetailQuery> list = context.getBeansByType(GoodDetailQuery.class);
        for(GoodDetailQuery query : list)
        {
           if(query.isSupport(channelCode))
            {
                return query.queryGood(id);
            }
        }
        return null;
    }


}
