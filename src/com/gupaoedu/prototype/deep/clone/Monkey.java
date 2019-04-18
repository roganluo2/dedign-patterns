package com.gupaoedu.prototype.deep.clone;


/**
 * @Description 猴子
 * @Date 2019/4/18 12:24
 * @Created by rogan.luo
 */
public class Monkey implements Cloneable , Prototype{

    private String name;

    private Integer id;

    private JingGuBand jingGuBand;

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

    public JingGuBand getJingGuBand() {
        return jingGuBand;
    }

    public void setJingGuBand(JingGuBand jingGuBand) {
        this.jingGuBand = jingGuBand;
    }


    public Monkey copy() {
        try {
            //先调用自身的clone，方法，然后对于引用对象，调用对象本身的clone方法
            Monkey clone = (Monkey) super.clone();
//            克隆后的引用对象的赋值
            clone.jingGuBand = getJingGuBand().clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
