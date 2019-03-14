package com.gupaoedu.prototype.shadow;

/**
 * @Description 提供拷贝的客服端，类比JSONObject
 * @Date 2019/3/14 20:43
 * @Created by rogan.luo
 */
public class MapClient {

//    完成从原型对象到目标对象属性的拷贝，浅拷贝
    public static Object map(Prototype prototype, Class clazz)
    {
       return prototype.clone(clazz);
    }
}
