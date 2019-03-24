package com.gupaoedu.observer.useguava;

/**
 * Created by 召君王 on 2019/3/25.
 */
public abstract class AbstractTeacherWork implements TeacherWork  {

    protected abstract String getName();

    @Override
    public void receiveQuestion(Question question) {
        System.out.println("========start====================");
        System.out.println(getName() + "老师，你好");
        System.out.println("你收到来自" + Gper.getInstance().getName() + "的提问，提问内容如下");
        System.out.println(question.getContent());
        System.out.println("========end====================");
    }
}
