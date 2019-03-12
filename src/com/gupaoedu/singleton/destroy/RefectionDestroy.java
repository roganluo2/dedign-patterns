package com.gupaoedu.singleton.destroy;

import com.gupaoedu.singleton.lazy.InnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * 采用反射暴力破坏
 */
public class RefectionDestroy {

    public static void main(String[] args) {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        Class clazz =   InnerClassSingleton.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor();
//            通过暴力调用构造函数 ，创建对象
            constructor.setAccessible(true);
            Object o2 = constructor.newInstance();
            System.out.println(instance == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
