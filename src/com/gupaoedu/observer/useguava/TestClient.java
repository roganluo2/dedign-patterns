package com.gupaoedu.observer.useguava;

/**
 * Created by 召君王 on 2019/3/25.
 */
public class TestClient {

    public static void main(String[] args) {
        Question question = new Question();
        question.setUsername("小红");
        question.setContent("适配器模式和装饰者模式的根本区别是啥？");
//        question.setInformTeacherName("tom");
        question.setInformTeacherName("mic");
        Gper.getInstance().publishQuestion(question);
    }

}
