package com.undergrowth;

import com.undergrowth.secure.Secured;
import com.undergrowth.secure.SecurityInterceptor;
import com.undergrowth.secure.Service;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-16-10:18
 */
public class SecureFrameworkTest {

    @Test
    public void secureTest() throws IllegalAccessException, InstantiationException {
        Service changeService = new ByteBuddy()
            .subclass(Service.class)
            .method(ElementMatchers.isAnnotatedWith(Secured.class))
            //.method(ElementMatchers.named("doSensitiveAction"))
            .intercept(MethodDelegation.to(new SecurityInterceptor())
                ).make()
            .load(getClass().getClassLoader())
            .getLoaded()
            .newInstance();
        changeService.doSensitiveAction();
    }

}