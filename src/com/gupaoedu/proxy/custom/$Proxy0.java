package com.gupaoedu.proxy.custom;
import com.gupaoedu.proxy.jdk.Clue;
import com.gupaoedu.proxy.jdk.IClueService;
import java.lang.reflect.*;
public final class $Proxy0 extends CtmProxy implements IClueService{
    CtmInvocationHandler h;
    public $Proxy0(CtmInvocationHandler h){
        this.h = h;
    }
    public final int modify(Clue arg0, Integer arg1){
        try {
            Method method = IClueService.class.getMethod("modify",Clue.class, Integer.class);
            return (int)h.invoke(this, method , new Object[]{arg0, arg1});
        }catch(Throwable throwable){
            throw new UndeclaredThrowableException(throwable);
        }
    }
}