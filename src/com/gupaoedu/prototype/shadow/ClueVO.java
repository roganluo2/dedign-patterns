package com.gupaoedu.prototype.shadow;

import java.util.List;

/**
 * @Description 拷贝出的目标类型
 * @Date 2019/3/14 20:40
 * @Created by rogan.luo
 */
public class ClueVO {

    private String name;

    private Integer id;

    private List<String> hobbies;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
