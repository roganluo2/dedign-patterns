package com.gupaoedu.singleton.test;

import com.gupaoedu.singleton.lazy.InnerClassSingleton;
import com.gupaoedu.singleton.register.HolderSingleton;
import com.gupaoedu.singleton.register.ThreadLocalSingleton;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class MainTest {


    public static void main(String[] args) {
//        testHolderSingleton();
//        testEnumSingleton();
//        testThreadLocalSingleton();
        testInnerClassSingleton();
    }

    private static void testInnerClassSingleton() {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();

    }

    private static void testThreadLocalSingleton() {

        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton instance2 = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton instance3 = ThreadLocalSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance3);
        Thread t1 = new ExecuteThread("myThread1"){
            @Override
            public void run() {
                ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
                ThreadLocalSingleton instance2 = ThreadLocalSingleton.getInstance();
                ThreadLocalSingleton instance3 = ThreadLocalSingleton.getInstance();
                System.out.println(instance);
                System.out.println(instance2);
                System.out.println(instance3);
            }
        };

        t1.start();
    }

    /**
     * 测试容器方式的单例
     */
    private static void testHolderSingleton() {
        Thread t1 = new ExecuteThread("myThread1");
        Thread t2 = new ExecuteThread("myThread2");
        t1.start();
        t2.start();
        System.out.println("end");

    }

    private static void testEnumSingleton() {
          Thread t1 = new ExecuteThread("myThread1");
          Thread t2 = new ExecuteThread("myThread2");
          t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        System.out.println("end");
    }

}
