package com.undergrowth.secure;

import java.lang.reflect.Method;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-10:14
 */
public class SecurityInterceptor {

    static String user = "ADMIN";

    @RuntimeType
    public void intercept(@AllArguments Object[] allArguments, @Origin Method method) {
        if (!method.getAnnotation(Secured.class).user().equals(user)) {
            throw new IllegalStateException("Wrong user");
        }
        System.out.println("pass security check method:" + method.getName());
    }

}