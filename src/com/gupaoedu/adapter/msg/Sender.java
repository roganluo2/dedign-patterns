package com.gupaoedu.adapter.msg;

import java.lang.annotation.*;

/**
 * Created by 召君王 on 2019/3/23.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Sender {
    String name() default "";
}
