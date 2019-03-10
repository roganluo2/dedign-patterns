package com.gupaoedu.factory.simple;

/**
 * Created by �پ��� on 2019/3/10.
 */
public class Shoes implements Product {

    public Shoes(Integer size) {
        this.size = size;
    }

    /**
     * ����
     */
    private Integer size;

    @Override
    public String getName() {
        return "鞋子";
    }

}
