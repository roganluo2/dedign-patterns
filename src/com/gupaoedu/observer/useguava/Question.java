package com.gupaoedu.observer.useguava;

/**
 * Created by 召君王 on 2019/3/24.
 */
public class Question {

    private String username;

    private String content;

    /**
     * 需要通知的人
     */
    private String informTeacherName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInformTeacherName() {
        return informTeacherName;
    }

    public void setInformTeacherName(String informTeacherName) {
        this.informTeacherName = informTeacherName;
    }
}
