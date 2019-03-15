package com.gupaoedu.proxy.jdk;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 召君王 on 2019/3/15.
 */
public class ProxyTest {

    public static void main(String[] args) {
        IClueService service = new ClueServiceImpl();
        AopProxy aopProxy = new AopProxy(service);
        IClueService serviceProxy = (IClueService) aopProxy.getInstance();
        Clue clue = new Clue();
        clue.setId(11);
        clue.setName("原型");
        List<String> h = new LinkedList<>();
        h.add("吃饭");
        h.add("睡觉");
        clue.setHobbies(h);
        int modify = serviceProxy.modify(clue, 123);
        System.out.println("====================================");

    }
}
