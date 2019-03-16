package com.gupaoedu.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

/**
 * Created by 召君王 on 2019/3/15.
 */
public class AopProxy implements InvocationHandler {

    private Object obj;

    public AopProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在这打印参数入口日志  类名 + 方法名  + 参数名 + 参数值
        StringBuffer sb = new StringBuffer();
        String className = method.getDeclaringClass().getSimpleName();
        sb.append(className).append(":");
        String methodName = method.getName();
        sb.append(methodName).append(":[");
        Parameter[] parameters = method.getParameters();
        for(int i = 0 ; i < parameters.length; i++ )
        {
            sb.append(parameters[i].getName()).append(", value :").append(args[i]).append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());
        Object invoke = method.invoke(obj, args);
        //在这打印方法出口口日志
        sb.append("-- 返回结果：").append(invoke);
        System.out.println(sb.toString());
        return invoke;
    }


    public Object getInstance(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces() , this);
    }

}
