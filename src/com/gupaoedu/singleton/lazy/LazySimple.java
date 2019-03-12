package com.gupaoedu.singleton.lazy;

public class LazySimple {

    private LazySimple(){}

    private static LazySimple INSTANCE;

    //直接在方法上加上synchronized锁，保证线程同步
    public synchronized static LazySimple getInstance(){
          if(INSTANCE == null)
          {
              INSTANCE = new LazySimple();
          }
          return INSTANCE;
    }
}
