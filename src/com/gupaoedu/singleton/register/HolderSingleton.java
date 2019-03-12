package com.gupaoedu.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HolderSingleton {

    private HolderSingleton (){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getObject(String className)
    {
        //方法进来，直接对容器加上锁，再获取对象
        synchronized (ioc)
        {
            if(!ioc.containsKey(className)) {
                Object o = null;
                try {
                    o = Class.forName(className).newInstance();
                    ioc.put(className, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                 return o;
            }
            else
            {
                return ioc.get(className);
            }
        }
    }


}
