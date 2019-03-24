package com.gupaoedu.observer.useguava;

import com.google.common.collect.Maps;
import com.google.common.eventbus.Subscribe;

import java.util.Map;

/**
 * Created by 召君王 on 2019/3/25.
 */
public class EventListener {

//    实际这些应该来自数据库
    private Map<String,Teacher> teacherMap = Maps.newHashMap();

    EventListener()
    {
        teacherMap.put("tom",new Teacher("tom"));
        teacherMap.put("mic",new Teacher("mic"));
        teacherMap.put("james",new Teacher("james"));
    }



    @Subscribe
    public void subscribe(Question question)
    {
        System.out.println("转发一个问题给" + question.getInformTeacherName() + "老师");
        Teacher teacher = teacherMap.get(question.getInformTeacherName());
        new GperTeacherWork(teacher).receiveQuestion(question);
    }

}
