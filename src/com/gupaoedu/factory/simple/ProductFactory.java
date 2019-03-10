package com.gupaoedu.factory.simple;

/**
 * Created by �پ��� on 2019/3/10.
 */
public class ProductFactory {

    public Product craete(Class clazz, Object... params)
    {
        if(clazz.equals(Shoes.class))
        {
            Integer size = 38;
            if(null != params)
            {
                size = Integer.parseInt(params[0].toString());
            }
            return new Shoes(size);
        }
        throw new RuntimeException("暂时还不能制造");
    }

}
