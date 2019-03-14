package com.gupaoedu.prototype.shadow;

import javafx.beans.property.Property;

/**
 * @Description 原型模式接口
 * @Date 2019/3/14 20:19
 * @Created by rogan.luo
 */
public interface Prototype {

    Object clone(Class clazz);

}
