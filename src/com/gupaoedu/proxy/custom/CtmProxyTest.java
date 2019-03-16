package com.gupaoedu.proxy.custom;

import com.gupaoedu.proxy.jdk.Clue;
import com.gupaoedu.proxy.jdk.ClueServiceImpl;
import com.gupaoedu.proxy.jdk.IClueService;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 自定义代理测试类
 * @Date 2019/3/16 16:21
 * @Created by rogan.luo
 */
public class CtmProxyTest {

    public static void main(String[] args) {

        IClueService service = new ClueServiceImpl();
        CtmLogService logService = new CtmLogService(service);
        IClueService serviceProxy = (IClueService) logService.getInstance();
        Clue clue = getClue();
        int modify = serviceProxy.modify(clue, 123);
    }

    private static Clue getClue() {
        Clue clue = new Clue();
        clue.setId(11);
        clue.setName("原型");
        List<String> h = new LinkedList<>();
        h.add("吃饭");
        h.add("睡觉");
        clue.setHobbies(h);
        return clue;
    }

}
