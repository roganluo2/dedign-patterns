package com.gupaoedu.observer.useguava;

/**
 * Created by 召君王 on 2019/3/25.
 */
public class GperTeacherWork extends AbstractTeacherWork {

    private Teacher teacher;

    public GperTeacherWork(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected String getName() {
        return teacher.getName();
    }

}
