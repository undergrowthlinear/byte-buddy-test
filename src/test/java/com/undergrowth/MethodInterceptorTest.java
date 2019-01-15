package com.undergrowth;

import com.undergrowth.interceptor.GreetingInterceptorComplex;
import com.undergrowth.interceptor.GreetingInterceptorSimple;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangwu
 * @version 1.0.0
 * @date 2019-01-15-11:51
 */
public class MethodInterceptorTest {

    @Test
    public void interceptorSimpleTest() throws IllegalAccessException, InstantiationException {
        Class<? extends java.util.function.Function> dynamicType = new ByteBuddy()
            .subclass(java.util.function.Function.class)
            .method(ElementMatchers.named("apply"))
            .intercept(MethodDelegation.to(new GreetingInterceptorSimple()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
        String str = (String) dynamicType.newInstance().apply("Byte Buddy");
        System.out.println(str);
        Assert.assertEquals("apply方法改写错误", str, "Hello from Byte Buddy");
    }

    @Test
    public void interceptorComplexTest() throws IllegalAccessException, InstantiationException {
        Class<? extends java.util.function.Function> dynamicType = new ByteBuddy()
            .subclass(java.util.function.Function.class)
            .method(ElementMatchers.named("apply"))
            .intercept(MethodDelegation.to(new GreetingInterceptorComplex()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
        String str = (String) dynamicType.newInstance().apply("Byte Buddy");
        System.out.println(str);
        Assert.assertEquals("apply方法改写错误", str, "Hello from Byte Buddy");
    }

    @Test
    public void interceptorComplex2Test() throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(MethodDelegation.to(new GreetingInterceptorComplex()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
        String str = (String) dynamicType.newInstance().toString();
        System.out.println(str);
        Assert.assertEquals("apply方法改写错误", str, "Hello from toString");
    }

}