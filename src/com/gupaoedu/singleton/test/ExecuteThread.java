package com.gupaoedu.singleton.test;

import com.gupaoedu.singleton.register.HolderSingleton;

public class ExecuteThread extends Thread {

    public ExecuteThread(String name)
    {
        this.setName(name);
    }

    @Override
    public void run() {
        //
//        EnumSingleton instance = EnumSingleton.getInstance();
//        instance.setObj(new Object());
        HolderSingleton object = (HolderSingleton) HolderSingleton.getObject(HolderSingleton.class.getName());

        System.out.println(object);
    }
}
