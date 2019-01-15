package com.undergrowth.interceptor;

import java.lang.reflect.Method;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-12:00
 */
public class GreetingInterceptorComplex {

    @RuntimeType
    public Object intercept(@AllArguments Object[] allArguments,
        @Origin Method method) {
        // intercept any method of any signature
        System.out.println("called:" + method.getName());
        if (allArguments != null && allArguments.length > 0) {
            return "Hello from " + allArguments[0];
        }
        return "Hello from " + method.getName();
    }

}