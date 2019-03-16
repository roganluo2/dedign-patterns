package com.gupaoedu.proxy.jdk;

import com.gupaoedu.prototype.shadow.Prototype;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 实现了原型接口的类，待拷贝的类
 * @Date 2019/3/14 20:36
 * @Created by rogan.luo
 */
public class Clue implements Prototype {

    private Integer id;

    private String name;

    private List<String> hobbies;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Method> getGetMethod() {
        return getMethod;
    }

    public void setGetMethod(Map<String, Method> getMethod) {
        this.getMethod = getMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Map<String,Method> getMethod = new ConcurrentHashMap<>();

    private Map<String,Method> resolveGetMethod (){
        if(!getMethod.isEmpty())
        {
            return  getMethod;
        }
        Method[] methods = this.getClass().getMethods();
        for(Method method : methods)
        {
            if(method.getName().startsWith("get") && method.getParameterCount() == 0) {
                getMethod.put(method.getName(), method);
            }
        }
        return getMethod;
    }

    @Override
    public Object clone(Class claz) {
        Map<String, Method> stringMethodMap = resolveGetMethod();
        try {
            Object o = claz.newInstance();
            Method[] methods = claz.getMethods();
            for(Method method : methods)
            {
                Method getMethod = stringMethodMap.get(method.getName().replace("set", "get"));
                if(method.getName().startsWith("set") &&  getMethod != null)
                {
                   method.invoke(o,getMethod.invoke(this));
                }
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
