package com.gupaoedu.strategy;

/**
 * 商品实体
 * Created by 召君王 on 2019/3/18.
 */
public class Goods {


    private Integer id;

    /**
     * 价格
     */
    private boolean money;

    /**
     * 商品名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isMoney() {
        return money;
    }

    public void setMoney(boolean money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
