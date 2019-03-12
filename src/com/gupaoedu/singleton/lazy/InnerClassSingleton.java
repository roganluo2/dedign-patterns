package com.gupaoedu.singleton.lazy;

public class InnerClassSingleton {

    private InnerClassSingleton(){
        System.out.println(11);
    }

    //final 预防方法被重写
    public final static InnerClassSingleton getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    static class SingletonHolder
    {
        public static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

}
