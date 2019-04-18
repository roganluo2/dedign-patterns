package com.gupaoedu.prototype.deep.clone;

/**
 * @Description 测试类
 * @Date 2019/4/18 12:30
 * @Created by rogan.luo
 */
public class MainTest {

    public static void main(String[] args)  {
        Monkey monkey  = new Monkey();
        monkey.setName("孙悟空");
        JingGuBand jingGuBand = new JingGuBand();
        jingGuBand.setSize(123);
        monkey.setJingGuBand(jingGuBand);
        Monkey clone  = monkey.copy();
        clone.setName("孙大圣");
        clone.getJingGuBand().setSize(567);
        System.out.println(monkey == clone);
        System.out.println(monkey.getName());
        System.out.println(monkey.getJingGuBand().getSize());
        System.out.println(monkey.getJingGuBand() == clone.getJingGuBand());
        System.out.println(clone.getName());
        System.out.println(clone.getJingGuBand().getSize());
    }
    
}
