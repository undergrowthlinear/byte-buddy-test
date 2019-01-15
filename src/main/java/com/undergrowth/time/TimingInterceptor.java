package com.undergrowth.time;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-14:02
 */
public class TimingInterceptor {

    @RuntimeType
    public static Object intercept(@Origin Method method,
        @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println(method + " took " + (System.currentTimeMillis() - start));
        }
    }

}