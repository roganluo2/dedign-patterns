package com.gupaoedu.singleton.lazy;

/**
 * 静态内部来类的方式，兼顾了饿汉的节约内存，又兼顾了sychronize的
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){
        System.out.println(11);
    }

    //final 预防方法被重写
    public final static InnerClassSingleton getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    //！！这里把类的修饰符改成私有的，只有外部类可以访问
    private static class SingletonHolder
    {
        //！！这里加了 final,防止被修改，同时属性也是用private，只能在当前内中访问
        private final static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

}
