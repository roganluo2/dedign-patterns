package com.gupaoedu.proxy.custom;

import java.lang.reflect.Method;

/**
 * @Description 自定义处理器
 * @Date 2019/3/16 11:21
 * @Created by rogan.luo
 */
public interface CtmInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
