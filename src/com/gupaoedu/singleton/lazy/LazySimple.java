package com.gupaoedu.singleton.lazy;

public class LazySimple {

    private LazySimple(){}

    private static LazySimple INSTACNE;

    //直接在方法上加上synchronized锁，保证线程同步
    public synchronized static LazySimple getInstance(){
          if(INSTACNE == null)
          {
              INSTACNE = new LazySimple();
          }
          return INSTACNE;
    }
}
