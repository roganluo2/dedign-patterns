package com.gupaoedu.singleton.destroy;

import com.gupaoedu.singleton.hungry.HungrySimple;
import com.gupaoedu.singleton.lazy.DoubleCheck;
import com.gupaoedu.singleton.lazy.InnerClassSingleton;
import com.gupaoedu.singleton.lazy.LazySimple;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 采用反射暴力破坏
 */
public class RefectionDestroy {

    public static void main(String[] args) {

//      思考 通过field去修改instance上没有加final修饰得字段。
        Class clazz = DoubleCheck.class;
        try {
            Field field = clazz.getDeclaredField("INSTANCE");
            field.setAccessible(true);
            field.set("INSTANCE", DoubleCheck.getInstance() );

        } catch (Exception e) {
            e.printStackTrace();
        }

//       testDestoryByConstructor();


    }

    private static void testDestoryByConstructor() {
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
