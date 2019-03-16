package com.gupaoedu.singleton.destroy;

import com.gupaoedu.singleton.register.EnumSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description 尝试破坏枚举的单例
 * @Date 2019/3/16 10:10
 * @Created by rogan.luo
 */
public class EnumSingleDestory {

    public static void main(String[] args) {
//        采用反射
//       destoryByReflection();
         //采用序列化
        try {
            EnumSingleton singleton1 = null;
            EnumSingleton singleton2 = EnumSingleton.getInstance();
            singleton2.setObj("我是第一个单例");
            String fileName = "EnumSingleton.obj";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(singleton2);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            singleton1 = (EnumSingleton) ois.readObject();
            singleton1.setObj("123");
            ois.close();
            System.out.println(singleton1 == singleton2);
            System.out.println(singleton1.getObj() == singleton2.getObj());
            System.out.println(singleton1.getObj());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void destoryByReflection() {

        try {
            //java.lang.NoSuchMethodException
//            Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor();

//            Cannot reflectively create enum objects
            Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            EnumSingleton enumSingleton = declaredConstructor.newInstance("123",1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
