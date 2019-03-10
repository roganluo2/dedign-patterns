package com.gupaoedu.factory.simple;

/**
 * Created by 召君王 on 2019/3/10.
 */
public class SimpleTest {

    public static void main(String[] args) {
        Product product = new ProductFactory().craete(Shoes.class, 43);
        System.out.println(product.getName());
    }
}
