package com.gupaoedu.prototype.shadow;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 测试原型模式
 * @Date 2019/3/14 20:43
 * @Created by rogan.luo
 */
public class PrototypeTest {


    public static void main(String[] args) {

        Clue clue = new Clue();
        clue.setId(11);
        clue.setName("原型");
        List<String> h = new LinkedList<>();
        h.add("吃饭");
        h.add("睡觉");
        clue.setHobbies(h);
        ClueVO clueVO = (ClueVO) MapClient.map(clue, ClueVO.class);
        System.out.println("clueVO Name"  + clueVO.getName());
        System.out.println("clueVO list"  + clueVO.getHobbies());

    }


}
