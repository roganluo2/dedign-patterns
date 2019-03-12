package com.gupaoedu.singleton.destroy;

import java.io.Serializable;

/**
 * 实现serializable 可以序列化
 */
public class SerializableSingleton implements Serializable {

    private SerializableSingleton(){
        System.out.println(11);
    }

    //final 预防方法被重写
    public final static SerializableSingleton getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    //！！这里把类的修饰符改成私有的，只有外部类可以访问
    private static class SingletonHolder
    {
        //！！这里加了 final,防止被修改，同时属性也是用private，只能在当前内中访问
        private final static SerializableSingleton INSTANCE = new SerializableSingleton();
    }

    //必须是返回Object
    private  Object readResolve(){
        return SingletonHolder.INSTANCE;
    }

}
