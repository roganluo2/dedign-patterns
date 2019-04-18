package com.gupaoedu.prototype.deep.clone;

/**
 * @Description 金箍棒
 * @Date 2019/4/18 12:26
 * @Created by rogan.luo
 */
public class JingGuBand implements Cloneable {

    private Integer size;

    private Integer weight;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    //重写方法，提供对外访问点
    @Override
    public JingGuBand clone()  {
        try {
            return (JingGuBand) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
