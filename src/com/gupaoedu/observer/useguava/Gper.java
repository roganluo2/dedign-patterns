package com.gupaoedu.observer.useguava;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * Created by 召君王 on 2019/3/24.
 */
public class Gper {
    private   String name = "GPer生态圈";

    public String getName() {
        return name;
    }

    private Gper(){}

    public static Gper getInstance(){
        return InnerSingleton.instance;
    }

    private static class InnerSingleton{
        private static Gper instance = new Gper();
    }

    public void publishQuestion( Question question)
    {
        System.out.println(question.getUsername() + "在" + this.name + "上提交了一个问题");
        Lists.newArrayList();
        EventBus eventBus = new EventBus();
        EventListener eventListener = new EventListener();
        eventBus.register(eventListener);
        eventBus.post(question);
    }
}
