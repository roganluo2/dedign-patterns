package com.gupaoedu.singleton.register;

import java.io.Serializable;

public enum  EnumSingleton implements Serializable {
    INSTANCE,
    NEW_INSTANCE,
    ;

    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static EnumSingleton getInstance()
    {
        return NEW_INSTANCE;
    }
}
