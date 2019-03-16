package com.gupaoedu.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 召君王 on 2019/3/15.
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception {
        IClueService service = new ClueServiceImpl();
        LogService aopProxy = new LogService(service);
        IClueService serviceProxy = (IClueService) aopProxy.getInstance();
        Clue clue = getClue();
        int modify = serviceProxy.modify(clue, 123);
        System.out.println("====================================");

//        获取代理源代码
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IClueService.class});
        FileOutputStream outputStream = new FileOutputStream("e:/workspace/$Proxy0.class");
        outputStream.write($Proxy0s);
        outputStream.flush();
        outputStream.close();;

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
